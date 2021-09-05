package com.roboseer.userservice.VO;

import com.roboseer.userservice.models.User;
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
