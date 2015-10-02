package org.biolink.service;

import com.google.gson.JsonObject;
import org.biolink.kernel.*;
import org.biolink.persistence.model.Person;
import org.biolink.persistence.model.TemplateImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/biolink")
public class ControllerService extends ApiController {

    private static final Logger logger =
            LoggerFactory.getLogger(ControllerService.class);

    @Autowired
    private BiolinkService bioLinkService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list() {
        logger.debug("exec: list");
        return "vopa";
    }

    @RequestMapping(value = "/create_new_person", method = RequestMethod.POST)
    @ResponseBody
    public String create_new_person(@RequestParam(value = "person_name") String name,
                                    @RequestParam(value = "id_keeper") String idKeeper,
                                    @RequestParam(value = "card_number") String cardNumber,
                                    @RequestParam(value = "card_internal_number") String cardInternalNumber
    ) throws IOException {
        Person person = new Person(name, idKeeper, cardNumber, cardInternalNumber);
        JsonObject result = new JsonObject();
        result.add("id", longToJson(bioLinkService.createPerson(person)));
        return result.toString();
    }

    @RequestMapping(value = "/creck_person", method = RequestMethod.GET)
    @ResponseBody
    public String creck_person() throws IOException {
        Person person = bioLinkService.findPersonByBilink();
        JsonObject result = new JsonObject();

        if (person != null) {
            result.add("id", longToJson(person.getId()));
            result.add("name", stringToJson(person.getName()));
            result.add("id_keeper", stringToJson(person.getIdKeeper()));
            result.add("card_number", stringToJson(person.getCardNumber()));
            result.add("card_internal_number", stringToJson(person.getCardInternalNumber()));

            List<TemplateImage> templateImages = person.getTemplateImages();
            if (templateImages.size() > 0) {
                JsonObject templ = new JsonObject();
                for (TemplateImage image : templateImages) {
                    templ.add("id_template", longToJson(image.getId()));
                }
                result.add("", templ);
            }
        }

        return result.toString();
    }


}
