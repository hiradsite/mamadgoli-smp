# نصب سریع
1. Paper 1.16.5 را به نام `paper.jar` کنار start.bat قرار بده.
2. یک بار `start.bat` را اجرا کن، سپس در eula.txt مقدار `eula=true` قرار بده.
3. برای Java/Bedrock، Geyser و Floodgate سازگار با 1.16.5 را در plugins قرار بده.
4. برای ساخت MamadgoliCore وارد `plugins/MamadgoliCore` شو و `mvn package` بزن.
5. فایل `target/MamadgoliCore-1.0.0.jar` را در `plugins/` قرار بده.
6. بعداً ماژول‌های Economy/Claims/Quests/Crates و API می‌توانند روی همین Core توسعه داده شوند.
