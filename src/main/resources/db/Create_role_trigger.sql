--To be executed only on DB

DELIMITER //

CREATE TRIGGER after_role_insert
AFTER INSERT ON roles
FOR EACH ROW
BEGIN
    -- Declare variables and cursor at the start of the BEGIN block
    DECLARE done INT DEFAULT 0;
    DECLARE ancestor_id BIGINT;
    DECLARE ancestor_cursor CURSOR FOR
        SELECT parentRoleId FROM role_closure
        WHERE childRoleId = NEW.parent_id;  -- Fetch ancestors of the parent role

    -- Declare the handler for when no more rows are found
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    -- Insert self-reference for the closure table (role to role)
    INSERT INTO role_closure (parentRoleId, childRoleId)
    VALUES (NEW.role_id, NEW.role_id);  -- Insert self-reference (role to role)

    -- Insert parent-child relationship if parent exists
    IF NEW.parent_id IS NOT NULL THEN
        -- Insert parent to new role
        INSERT INTO role_closure (parentRoleId, childRoleId)
        VALUES (NEW.parent_id, NEW.role_id);  -- parent to new role

        -- Open the cursor to fetch ancestor roles
        OPEN ancestor_cursor;

        -- Loop through ancestors and insert relationships
        read_loop: LOOP
            FETCH ancestor_cursor INTO ancestor_id;
            IF done THEN
                LEAVE read_loop;
            END IF;

            -- Insert the ancestor-child relationship into the closure table
            INSERT INTO role_closure (parentRoleId, childRoleId)
            VALUES (ancestor_id, NEW.role_id);  -- ancestor to new role
        END LOOP;

        -- Close the cursor
        CLOSE ancestor_cursor;
    END IF;
END //

DELIMITER ;