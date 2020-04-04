package heroku.demo;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ImportSheetsGoogleJson {

    private static final String URLGOOGLE = "https://script.google.com/macros/s/AKfycbxbXbG3Gb5sEM2kfRxrFrtQEqSo0dgv_v9ZC4uvRjjLRLnJY8ZH/exec";
    private MapperJsonToPointDto mapperJsonToPointDto;

    public ImportSheetsGoogleJson(MapperJsonToPointDto mapperJsonToPointDto) {
        this.mapperJsonToPointDto = mapperJsonToPointDto;
    }

    public List<RowDTO> getJson() {
        RestTemplate restTemplate = new RestTemplate();
        String stringJson = restTemplate.getForObject(URLGOOGLE, String.class);
        Gson gson = new Gson();
        ListJsonDTO user = gson.fromJson(stringJson, ListJsonDTO.class);
        return user.getUser();
    }

    public List<PointDTO> getJson2() {
        List<RowDTO> json = getJson();
        return mapperJsonToPointDto.map(json);
    }


}
