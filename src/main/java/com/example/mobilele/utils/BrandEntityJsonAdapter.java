package com.example.mobilele.utils;

import com.example.mobilele.models.entities.BrandEntity;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.Instant;

public class BrandEntityJsonAdapter extends TypeAdapter<BrandEntity> {
    @Override
    public void write(JsonWriter out, BrandEntity value) throws IOException {
        out.beginObject();
        out.name("name");
        out.value(value.getName());
        out.name("created");
        out.value(value.getCreated().toString());
        out.name("modified");
        out.value(value.getModified().toString());
        out.endObject();
    }

    @Override
    public BrandEntity read(JsonReader in) throws IOException {
        in.beginObject();
        in.nextName();
        String name = in.nextString();
        in.nextName();
        String created = in.nextString();
        in.nextName();
        String modified = in.nextString();
        in.endObject();
        return (BrandEntity) new BrandEntity().setName(name).setCreated(Instant.parse(created)).setModified(Instant.parse(modified));

    }
}
