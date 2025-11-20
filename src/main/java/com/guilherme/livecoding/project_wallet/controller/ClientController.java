package com.guilherme.livecoding.project_wallet.controller;

import com.guilherme.livecoding.project_wallet.dto.request.CreateClientRequest;
import com.guilherme.livecoding.project_wallet.dto.response.ClientResponse;
import com.guilherme.livecoding.project_wallet.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientResponse> creatClient(@RequestBody CreateClientRequest request){
        try {
            var response = service.create(request);
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);
         }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: an unexpected condition prevented the server from completing the request.");
        }
    }

@GetMapping
    public ResponseEntity<ClientResponse> getAllClients(){
try {
    List<ClientResponse> responses = service.getAllClients();
    return ResponseEntity.ok(responses);
} catch (Exception e){
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: an unexpected condition prevented the server fron completing the request")
}
}

@GetMapping("/{id}")
public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id){
        try {
         var response =service.getClientById(id);
         return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: an unexpected condition prevented the server fron complting the request")
        }
}

}
