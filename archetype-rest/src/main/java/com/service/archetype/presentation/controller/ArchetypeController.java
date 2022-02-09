package com.service.archetype.presentation.controller;

import com.service.archetype.domain.usecase.ProjectGenerateUseCase;
import com.service.archetype.domain.usecase.UploadTemplateUseCase;
import com.service.archetype.presentation.model.UploadTemplateRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("archetype")
public class ArchetypeController {

    private ProjectGenerateUseCase projectGenerateUseCase;
    private UploadTemplateUseCase uploadTemplateUseCase;

    public ArchetypeController(
            ProjectGenerateUseCase projectGenerateUseCase,
            UploadTemplateUseCase uploadTemplateUseCase) {
        this.projectGenerateUseCase = projectGenerateUseCase;
        this.uploadTemplateUseCase = uploadTemplateUseCase;
    }

    @PostMapping("/template")
    public ResponseEntity<String> uploadTemplate(@RequestBody UploadTemplateRequestModel uploadTemplateRequestModel) {
        this.uploadTemplateUseCase.upload(uploadTemplateRequestModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/project")
    public ResponseEntity<String> projectGenerate(@RequestBody String requestModel) {
        this.projectGenerateUseCase.generate(requestModel);

        String helloWorld = "Crea un usuario";
        return new ResponseEntity<>(helloWorld, HttpStatus.OK);
    }
}
