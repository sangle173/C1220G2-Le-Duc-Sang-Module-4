package com.example.provinces_manager.formatter;

import com.example.provinces_manager.model.Province;
import com.example.provinces_manager.service.IProvinceService;
import com.example.provinces_manager.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }
    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Province province= (Province) provinceService.findById(Integer.parseInt(text));
        return province;
    }

    @Override
    public String print(Province object, Locale locale) {
        return "["+object.getId()+","+object.getName()+"]";
    }
}
