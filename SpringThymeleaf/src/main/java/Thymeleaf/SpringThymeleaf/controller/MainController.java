package Thymeleaf.SpringThymeleaf.controller;

import Thymeleaf.SpringThymeleaf.domain.Album;
import Thymeleaf.SpringThymeleaf.domain.Singer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model){


        // 데이터 생성
        List<Singer> list = new ArrayList<>();
        Singer singer = new Singer();
        singer.setName("BTS");
        singer.setAge("20");
        List<Album> albs = new ArrayList<>();
        Album item = new Album();
        item.setAlbumName("앨범1");
        item.setAlbumVersion("1");
        albs.add(item);
        item.setAlbumName("앨범2");
        item.setAlbumVersion("2");
        albs.add(item);
        singer.setAlubums(albs);
        list.add(singer);
        Singer singer2 = new Singer();
        singer2.setName("세븐틴");
        singer2.setAge("30");
        List<Album> albs2 = new ArrayList<>();
        Album albm2 = new Album();
        albm2.setAlbumVersion("");
        albm2.setAlbumName("");
        albs2.add(albm2);
        singer2.setAlubums(albs2);
        list.add(singer2);

        Singer singer3 = new Singer();
        singer3.setName("에스파");
        singer3.setAge("10");
        list.add(singer3);
        model.addAttribute("list",list);
        return "index";
    }

    @ResponseBody
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody List<Singer> parameters) throws JsonProcessingException {
        try{
            //String json = parameters.get("param").toString();
            ObjectMapper mapper =  new ObjectMapper();
            //List<Map<String, Object>> param = mapper.readValue(json,new TypeReference<ArrayList<Map<String, Object>>>(){});
        //    List<Singer> paramList = mapper.readValue(json, new TypeReference<ArrayList<Singer>>(){});

            for (Singer parameter : parameters) {
                System.out.println(parameter.getName());
                for (Singer singer : parameters) {
                    System.out.println(singer.getAlubums().stream().findFirst().get().getAlbumName());
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @GetMapping("/main")
    public String main(){

        return "main";
    }



}
