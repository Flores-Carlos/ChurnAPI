package com.challenge.churn.controller;

import com.challenge.churn.model.Cliente;
import com.challenge.churn.model.Empresa;
import com.challenge.churn.repo.EmpresaRepo;
import com.challenge.churn.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepo clienteRepo;
    private EmpresaRepo empresaRepo;

    @GetMapping(value = "/clientes")
    public String listClientes(Model model) {
        List<Cliente> clientes = clienteRepo.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping(value = "/cliente/{id}")
    public String getCliente(@PathVariable long id, Model model) {
        Cliente cliente = clienteRepo.findById(id).orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente-detail";
        } else {
            return "404";
        }
    }

    @GetMapping(value = "/cliente/create")
    public String createClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        List<Empresa> empresas = empresaRepo.findAll();
        return "cliente-form";
    }

    @PostMapping(value = "/cliente/create")
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteRepo.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping(value = "/cliente/edit/{id}")
    public String editClienteForm(@PathVariable long id, Model model) {
        Cliente cliente = clienteRepo.findById(id).orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente-form";
        } else {
            return "404";
        }
    }

    @PostMapping(value = "/cliente/update/{id}")
    public String updateCliente(@PathVariable long id, @ModelAttribute Cliente cliente) {
        Cliente existingCliente = clienteRepo.findById(id).orElse(null);
        if (existingCliente != null) {
            existingCliente.setNome(cliente.getNome());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setEmpresa(cliente.getEmpresa());
            clienteRepo.save(existingCliente);
            return "redirect:/clientes";
        } else {
            return "404";
        }
    }

    @GetMapping(value = "/cliente/delete/{id}")
    public String deleteCliente(@PathVariable long id) {
        Cliente cliente = clienteRepo.findById(id).orElse(null);
        if (cliente != null) {
            clienteRepo.delete(cliente);
        }
        return "redirect:/clientes";
    }
}
