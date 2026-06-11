# SMM Bot

Телеграм-бот, який генерує готові пости для Instagram за заданою темою. Текст створює модель
`gemini-3.1-flash-lite-preview` у форматі: заголовок, текст, заклик до дії та хештеги.

## Технології

- Java 21, Maven
- telegrambots
- google-genai

## Запуск

Потрібні дві змінні середовища:

| Змінна           | Призначення                 |
|------------------|-----------------------------|
| `TELEGRAM_TOKEN` | токен бота від @BotFather   |
| `GOOGLE_API_KEY` | ключ Gemini API (AI Studio) |

```bash
export TELEGRAM_TOKEN=...
export GOOGLE_API_KEY=...

mvn compile exec:java -Dexec.mainClass=org.smmbot.Main
```

## Використання

- `/start` — перевірка, що бот живий
- будь-яке інше повідомлення — тема, за якою генерується пост
