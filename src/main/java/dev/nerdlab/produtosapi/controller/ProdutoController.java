package dev.nerdlab.produtosapi.controller;

import dev.nerdlab.produtosapi.model.Produto;
import dev.nerdlab.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido com sucesso: " + produto);
        produtoRepository.save(produto);
        return produto;
    }


}
