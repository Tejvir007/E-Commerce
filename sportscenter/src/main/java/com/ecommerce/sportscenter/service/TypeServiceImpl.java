package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Type;
import com.ecommerce.sportscenter.model.TypeResponse;
import com.ecommerce.sportscenter.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    @Override
    public List<TypeResponse> getAllTypes(){
        log.info("getting all types!!");
        List<Type> typeList=typeRepository.findAll();
        List<TypeResponse> typeResponses=typeList.stream()
                .map(this::convertToTypeResponse)
                .collect(Collectors.toList());

        return typeResponses;
    }
    private TypeResponse convertToTypeResponse(Type type){
        return TypeResponse.builder()
                .id(type.getId())
                .name(type.getName())
                .build();
    }

}
