package task.controller;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import sun.awt.image.AbstractMultiResolutionImage;
import task.model.EnvelopeModel;
import task.service.EnvelopeService;
import task.util.Input;
import task.util.OutPut;
import task.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeController {

    Input input = new Input();
    OutPut outPut = new OutPut();
    Validator validator = new Validator();
    EnvelopeService envelopeService = new EnvelopeService();
    EnvelopeModel envelopeModel;

    public void run () {
        List<EnvelopeModel> envelopeList = new ArrayList<>();
        while (true) {
            try {
                for (int i = 0; i < 2; i++) {
                    outPut.getStartInfo(i);
                    envelopeList.add(createEnvelopeModel());
                    envelopeService.findDiagonal(envelopeList.get(i));
                }
                if (envelopeService.rectangleS(envelopeList, 0, 1)) {
                    outPut.OutPutResult(envelopeList, 0, 1);
                } else outPut.OutPutResult(envelopeList, 1, 0);
            } catch (Exception e) {
                outPut.getInfoMistake();
            }
            outPut.getInfoRequest();
            if (!validator.continuedRequest(input.getString().toUpperCase())) {
                break;
            }
        }
    }

    private EnvelopeModel createEnvelopeModel() throws Exception {
        String[] str = validator.getSplitArray(input.getString());
        return new EnvelopeModel(Float.parseFloat(str[0]),Float.parseFloat(str[1]));
    }
}
