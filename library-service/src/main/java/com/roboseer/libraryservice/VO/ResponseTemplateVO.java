package com.roboseer.libraryservice.VO;

import com.roboseer.libraryservice.models.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO
{
    private User user;
    private List<Library> libraryList;
}
