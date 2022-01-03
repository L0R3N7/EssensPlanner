package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListGerichtDTO implements Serializable {
    List<GerichtDTO> gerichtDTOList = new ArrayList<>();

    public ListGerichtDTO(List<GerichtDTO> gerichtDTOList) {
        this.gerichtDTOList = gerichtDTOList;
    }

    public ListGerichtDTO() {
    }

    public List<GerichtDTO> getGerichtDTOList() {
        return gerichtDTOList;
    }

    public void setGerichtDTOList(List<GerichtDTO> gerichtDTOList) {
        this.gerichtDTOList = gerichtDTOList;
    }
}
