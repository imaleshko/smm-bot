package org.smmbot;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;

public class Gemini {

    private static final String MODEL = "gemini-3.1-flash-lite-preview";

    private final Client client = new Client();

    public String generatePost(String topic) {
        GenerateContentConfig config = GenerateContentConfig.builder()
                .systemInstruction(Content.fromParts(
                        Part.fromText("""
                                Ти — SMM-спеціаліст. Пиши виключно українською мовою.
                                Генеруй пост для Instagram у форматі:
                                
                                📌 ЗАГОЛОВОК
                                📝 ТЕКСТ (3–5 речень)
                                🚀 CTA (заклик до дії)
                                #хештег1 #хештег2 #хештег3 #хештег4 #хештег5
                                """)))
                .build();

        GenerateContentResponse response = client.models.generateContent(
                MODEL,
                "Тема посту: " + topic,
                config
        );

        return response.text();
    }
}
