package dev.nerdlab.produtosapi.controller;

import dev.nerdlab.produtosapi.model.Produto;
import dev.nerdlab.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido com sucesso: " + produto);
        produto.setId(UUID.randomUUID().toString());
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletaPorId(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
        System.out.println("Produto com Id: " + id + "\nDeletado com sucesso");
    }

    @PutMapping("{id}")
    public void updatePorId(@PathVariable String id,
                            @RequestBody Produto prod){
        prod.setId(id);
        produtoRepository.save(prod);
    }

    @GetMapping
    public List<Produto> buscarPorParam(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }

}
