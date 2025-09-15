# Learn PHP

Trong phần này thì mình sẽ học một số thứ cơ bản về Php. Mục tiêu là có thể phát triển được RESTful API và xa hơn là ứng dụng web với Php.

## Requirements

Mình khuyến nghị là nên dùng Linux để học php, vì nó setup rất dễ. Còn Windows thì yêu cầu nhiều thứ hơn.

## Instalation

Để cài đặt Java thì xem các hướng dẫn dưới đây:

- Windows: [xem thêm tại đây](https://wiki.php.net/internals/windows/php-windows-builder).
- Linux (Ubuntu): [xem thêm tại đây](https://dev.to/hasarali/how-to-setup-a-php-development-environment-with-the-latest-php-vscode-apache-phpmyadmin-5-on-ubuntu-works-on-wsl2-d7).

## Run

Để có thể chạy được ứng dụng PHP, thì cần phải đảm bảo là:

- Vào trong thư mục của từng bài.
- Trong mỗi thư mục của từng bài phải có file `index.php`.

Khi đã đáp ứng đủ điều kiện thì chạy lệnh.

```bash
php -S localhost:5500
```

> Note: tham số `-S` trong lệnh `php` có nghĩa là `-S <addr>:<port> Run with built-in web server.`.

> Note: đây là hướng dẫn chung cho hầu hết các chương trình php có trong thư mục này. Về sau sẽ có nhiều chương trình phức tạp hơn nên sẽ có cách setup riêng.
