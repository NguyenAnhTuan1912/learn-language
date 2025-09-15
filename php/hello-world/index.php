<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  <link rel="stylesheet" href="./style.css" />
</head>

<body>
  <div id="root" class="p-3">
    <!-- My first php -->
    <!-- Echo có nghĩa là mình sẽ ghi một chuỗi nào đó ra bên ngoài trình duyệt. -->
    <div class="lesson">
      <strong>My first PHP</strong>
      <p>Các đoạn mã PHP sẽ được đặt trong khối &lt;?php ?&gt;</p>

      <p>
        <?php
        echo "Xin chào, mình là Tuấn, đây là ứng dụng PHP đầu tiên của mình !!";
        ?>
      </p>

      <p>
        <?php
        echo "Vì PHP nó theo dạng template HTML, nếu có build SSR APP với NodeJS thì cũng khá quen với kiểu này!! Nên là học nó cũng dễ, nhưng lifecycle nó sẽ khác khi so với RESTful.";
        ?>
      </p>

      <p>
        <?php
        echo "Mình vẫn có thể viết CSS, Javascript ở trong này. Cũng có thể import một số các thành phần khác.";
        ?>
      </p>

      <p>
        <?php
        echo "Mình cũng có thể module hoá ứng dụng PHP, nhưng trong bài sau mình sẽ học.";
        ?>
      </p>
    </div>


    <!-- Variable & expression -->
    <div class="lesson">
      <strong>Variable & expression</strong>
      <p>
        <?php
        // Để khai báo một biến thì mình sẽ cần phải dùng kí tự $ ở trước.
        $text = "Xin chào, đây là cách khai báo biến trong php";
        echo "Mình dùng echo để in chữ ra: $text";
        ?>
      </p>

      <p>
        <?php
        echo "Mình cũng có thể dùng hàm echo để in ra thẻ html <br/>";
        echo "<strong>Đây là ví dụ (thực chất ở trên mình cũng có dùng nên là mới xuống dòng được)</strong>"
        ?>
      </p>

      <p>
        Để có thể biết được kiểu dữ liệu của biến, thì mình có thể dùng hàm <code>var_dump()</code> <br />
        <?php
        $str = "Random text";
        $n = 23;
        $fl = 23.42;
        $arr = [1, 2, 3, 4, 5];

        echo "Kiểu dữ liệu của str: ";
        var_dump($str);
        echo "<br/>";

        echo "Kiểu dữ liệu của n: ";
        var_dump($n);
        echo "<br/>";

        echo "Kiểu dữ liệu của fl: ";
        var_dump($fl);
        echo "<br/>";

        echo "Kiểu dữ liệu của arr: ";
        var_dump($arr);
        echo "<br/>";

        echo "Kiểu dữ liệu của NULL: ";
        var_dump(NULL);
        echo "<br/>";
        ?>

        Hoặc có thể là dung <code>gettype()</code>, nhưng sẽ không chi tiết bằng <code>var_dump()</code> <br />
        <?php
        $str = "Random text";
        $n = 23;
        $fl = 23.42;
        $arr = [1, 2, 3, 4, 5];

        echo "Kiểu dữ liệu của str: " . gettype($str) . "<br/>";
        echo "Kiểu dữ liệu của n: " . gettype($n) . "<br/>";
        echo "Kiểu dữ liệu của fl: " . gettype($fl) . "<br/>";
        echo "Kiểu dữ liệu của arr: " . gettype($arr) . "<br/>";
        echo "Kiểu dữ liệu của NULL: " . gettype(NULL) . "<br/>";
        ?>
      </p>
    </div>

    <!-- First thought about lifecycle of PHP -->
    <div class="lesson">
      <strong>First thought about lifecycle of PHP</strong>
      <p>
        Như mình đã có nói trước đó, thì php nó sẽ là dạng SSR dùng Template HTML để thay đổi nội dung cho trang web.
        Vì thế khi mình start up ứng dụng lên, nó sẽ có một file cấu hình của riêng nó, nó sẽ nhờ file này mà "sử dụng ứng dụng"
        php của mình. Vì có process đang chạy, nó sẽ xử lý các template có đuôi <code>.php</code> để build ra HTML cuối,
        nghĩa là mã nguồn của PHP mà mình đang code và chính process server đó là độc lập, khác với Python hay Node, mình
        sẽ start một process server dự trên mã của chúng, còn php thì lại khác.
      </p>
      <p>
        Điều này đồng nghĩa với việc là mình sẽ không cần hot reload để xem nội dung mới của trang web, nhưng nhớ lưu
        ý tới cache.
      </p>
      <p>
        Bạn có thể refresh lại trang web để thấy giá trị này thay đổi:
        <span class="font-medium text-red-500">
          <?php
          $random_n = random_int(0, 100);
          print("$random_n");
          ?>
        </span>
      </p>
    </div>
  </div>
</body>

</html>