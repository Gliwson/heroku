package heroku.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Log4j2
@RestController
@RequestMapping
public class MapRestController {

    private DataRepoCSV dataRepo;
    private ImportSheetsGoogleJson importSheetsGoogleJson;

    public MapRestController(DataRepoCSV dataRepo, ImportSheetsGoogleJson importSheetsGoogleJson) {
        this.dataRepo = dataRepo;
        this.importSheetsGoogleJson = importSheetsGoogleJson;
    }

    @GetMapping
    public String start() {
        return "Start";
    }


    @GetMapping("/reload")
    public String reloadData() {
        dataRepo.clear();
        importSheetsGoogleJson.getJson2();
        return "DONE";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/test")
    public PointDTO reloadData2() {
        log.info("getAllProducts");
        return dataRepo.getPointList().get(1);
    }
}
