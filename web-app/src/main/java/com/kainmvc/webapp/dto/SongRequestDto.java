package com.kainmvc.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SongRequestDto implements Validator {
    private Long id;
    private String songName;
    private String category;
    private String singer;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongRequestDto songRequestDto =(SongRequestDto) target;
        if(songRequestDto.getSongName().isEmpty()){
            errors.rejectValue("songName","Empty","Không được để trống");
        } else if (!songRequestDto.getSongName().matches("^.{1,800}$")) {
            errors.rejectValue("songName","MoreThan800","Không được quá 800 ký tự");
        }else if(songRequestDto.getSongName().matches("^[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]+$")){
            errors.rejectValue("songName","SpecialKeyword","Không được chứa ký tự đặc biệt");
        }

        if(songRequestDto.getSinger().isEmpty()){
            errors.rejectValue("singer","Empty","Không được để trống");
        } else if (!songRequestDto.getSinger().matches("^.{1,300}$")) {
            errors.rejectValue("singer","MoreThan300","Không được quá 800 ký tự");
        }else if(songRequestDto.getSinger().matches("^[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]+$")){
            errors.rejectValue("singer","SpecialKeyword","Không được chứa ký tự đặc biệt");
        }

        if(songRequestDto.getCategory().isEmpty()){
            errors.rejectValue("category","Empty","Không được để trống");
        } else if (!songRequestDto.getCategory().matches("^.{1,1000}$")) {
            errors.rejectValue("category","MoreThan1000","Không được quá 800 ký tự");
        }else if(songRequestDto.getCategory().matches("^[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]+$")){
            errors.rejectValue("category","SpecialKeyword","Không được chứa ký tự đặc biệt");
        }
    }
}
