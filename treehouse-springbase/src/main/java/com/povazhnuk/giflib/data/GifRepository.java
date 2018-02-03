package com.povazhnuk.giflib.data;

import com.povazhnuk.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("test", LocalDate.of(2017,9,13), "Slava", true),
            new Gif("dasha", LocalDate.of(2017,9,13), "Dasha", true)
    );

    public Gif findByName(String name) {
        for(Gif gif:ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }
}
