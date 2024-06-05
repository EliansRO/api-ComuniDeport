package com.comunideport.rest.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comunideport.rest.Controllers.dto.ResultDTO;
import com.comunideport.rest.Entities.Result;
import com.comunideport.rest.Service.IResultService;

@RestController
@RequestMapping("/api/result")
public class ResultController {

    @Autowired
    private IResultService resultService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Result> resultOptional = resultService.findById(id);

        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();

            ResultDTO resultDTO = ResultDTO.builder()
                .id(result.getId())
                .team_local(result.getTeam_local())
                .team_visit(result.getTeam_visit())
                .score_local(result.getScore_local())
                .score_visit(result.getScore_visit())
                .build();

            return ResponseEntity.ok(resultDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ResultDTO> resultDTOs = resultService.findAll()
            .stream()
            .map(result -> ResultDTO.builder()
                .id(result.getId())
                .team_local(result.getTeam_local())
                .team_visit(result.getTeam_visit())
                .score_local(result.getScore_local())
                .score_visit(result.getScore_visit())
                .build()
            )
            .toList();

        return ResponseEntity.ok(resultDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ResultDTO resultDTO) throws URISyntaxException {
        if (resultDTO.getTeam_local() == null || resultDTO.getTeam_visit() == null) {
            return ResponseEntity.badRequest().build();
        }

        Result result = Result.builder()
            .id(resultDTO.getId())
            .team_local(resultDTO.getTeam_local())
            .team_visit(resultDTO.getTeam_visit())
            .score_local(resultDTO.getScore_local())
            .score_visit(resultDTO.getScore_visit())
            .build();

        resultService.save(result);

        return ResponseEntity.created(new URI("/api/result/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateResult(@RequestBody ResultDTO resultDTO, @PathVariable Integer id) throws URISyntaxException {
        Optional<Result> resultOptional = resultService.findById(id);

        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();
            result.setTeam_local(resultDTO.getTeam_local());
            result.setTeam_visit(resultDTO.getTeam_visit());
            result.setScore_local(resultDTO.getScore_local());
            result.setScore_visit(resultDTO.getScore_visit());

            resultService.save(result);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteResult(@PathVariable Integer id) {
        if (id != null) {
            resultService.deleteById(id);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.badRequest().build();
    }
}