package com.cyfrifpro.restcontrollers;

import com.cyfrifpro.model.UCC.FirstPersonalInformation;
import com.cyfrifpro.services.FirstPersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personal-information")
public class ClientController {

	@Autowired
	private FirstPersonalInformationService firstPersonalInformationService;

	@GetMapping("/get_all_personal_information")
    public List<FirstPersonalInformation> getAllPersonalInformation() {
        return firstPersonalInformationService.getAllData();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<FirstPersonalInformation> getById(@PathVariable Long id) {
        Optional<FirstPersonalInformation> data = firstPersonalInformationService.getById(id);
        return data.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/clientCodeUcc/{clientCodeUcc}")
    public ResponseEntity<FirstPersonalInformation> getByClientCodeUcc(@PathVariable String clientCodeUcc) {
        Optional<FirstPersonalInformation> data = firstPersonalInformationService.getByClientCodeUcc(clientCodeUcc);
        return data.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
