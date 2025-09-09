package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.CategoriaDTOUpdateRequest;
import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaDTOUpdateResponse;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    private ModelMapper modelMapper;
    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }
    public CategoriaResponse criarCategoria(CategoriaRequest categoriaRequest){
        Categoria categoria = this.modelMapper.map(categoriaRequest,Categoria.class);
        Categoria categoriaSalva = this.categoriaRepository.save(categoria);
        CategoriaResponse categoriaResponse = this.modelMapper.map(categoriaSalva,CategoriaResponse.class);
        return categoriaResponse;
    }
    public List<Categoria> listarCategorias(){
        return this.categoriaRepository.listarCategoria();
    }

    public CategoriaResponse retornarCategoria (Integer id){
        return  modelMapper.map(this.categoriaRepository.obterCategoriaPorId(id),CategoriaResponse.class);
    }

    public CategoriaResponse atualizarCategoria(Integer categoriaId, CategoriaRequest request){
        Categoria categoria = this.categoriaRepository.obterCategoriaPorId(categoriaId);
        if (categoria != null){
            modelMapper.map(request,categoria);
            Categoria categoriaSalvo = this.categoriaRepository.save(categoria);
            return modelMapper.map(categoriaSalvo,CategoriaResponse.class);
        }else{
            throw new IllegalArgumentException("Categoria não existe");
        }
    }


    public void apagarCategoria(Integer categoriaId){
        this.categoriaRepository.apagarCategoria(categoriaId);
    }



}
