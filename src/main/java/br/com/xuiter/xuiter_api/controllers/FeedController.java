package br.com.xuiter.xuiter_api.controllers;

import br.com.xuiter.xuiter_api.dto.XuitResponse;
import br.com.xuiter.xuiter_api.entities.Xuit;
import br.com.xuiter.xuiter_api.repositories.XuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    private final XuitRepository xuitRepository;

    public FeedController(XuitRepository xuitRepository) {
        this.xuitRepository = xuitRepository;
    }

    @GetMapping("/feed")
    public List<XuitResponse> feed(){
        return xuitRepository.findAll().stream().map(XuitResponse::new).toList();
    }

}
