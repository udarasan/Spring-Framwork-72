package org.example.controller;

import jakarta.servlet.annotation.MultipartConfig;
import org.example.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //save customer - form data (x-www form URL Encoded)
    //CIDs - Customer ID
    //CName - Customer Name
    //CAddress - Customer Address
     @PostMapping("/save")
    public String saveCustomer(@ModelAttribute CustomerDTO customerDTO){
        System.out.println(customerDTO.getCID());
        System.out.println(customerDTO.getCName());
        System.out.println(customerDTO.getCAddress());
        return "Customer Saved";
    }
    //save customer - Query Params
    @PostMapping(params = {"CID","CName","CAddress"})
    public String saveCustomerQueryParams(
            @RequestParam("CID") String CID,
            @RequestParam("CName")  String CName,
            @RequestParam("CAddress")  String CAddress){
        System.out.println(CID);
        System.out.println(CName);
        System.out.println(CAddress);
        return "Customer Saved";
    }

    //save customer - Path Variable
    @PostMapping(path = "saveWithPathVariable/{CID}/{CName}/{CAddress}")
    public String saveCustomerPathVariables(
            @PathVariable("CID") String CID,
            @PathVariable("CName") String CName,
            @PathVariable("CAddress") String CAddress){
        System.out.println(CID);
        System.out.println(CName);
        System.out.println(CAddress);
        return "Customer Saved";
    }

    //Save Customer - JSON
    @PostMapping(path = "saveWithJSON",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String saveCustomerWithJSON(
            @RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO.getCID());
        System.out.println(customerDTO.getCName());
        System.out.println(customerDTO.getCAddress());
        return "Customer Saved";
    }

    //Return JSON Object
    @GetMapping(path = "getCustomer", produces
            = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerDTO getCustomer(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCID("101");
        customerDTO.setCName("Rajesh");
        customerDTO.setCAddress("Chennai");
        return customerDTO;
    }



}
