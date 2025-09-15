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
    <p>Trong phần này thì mình sẽ nói sơ qua về Scope trong PHP, nó khác gì so với Python, Javascript và Java ...</p>

    <div class="lesson">
      <strong>Global variable with function</strong>
      <p>Trong PHP có 3 loại scope, lần lượt là: <strong>local</strong>, <strong>global</strong> và <strong>static</strong>.</p>

      <p>Trước tiên là mình sẽ khai báo một biến x và dùng trong hàm <code>increase()</code></p>
      <?php
      // Đây là biến global, vì nó nằm ở ngoài cùng của đoạn mã.
      $x = 5;

      // Giờ mình sẽ khai báo một function
      function increase()
      {
        // Lỗi: Undefined variable '$x'.
        // Mặc dù có lỗi, nhưng php vẫn render HTML bình thường.
        echo "<p>Nó sẽ báo lỗi khi cố truy cập biến x: $x</p>";
      }

      increase();
      ?>
    </div>

    <div class="lesson">
      <strong>Use global variable in local</strong>
      <p>Có một số cách dùng biến global như sau.</p>
      <p>
        Trước tiên là mình sẽ khai báo <code>$x</code> trong <code>increase_by_100()</code>
        sau đó là dùng từ khoá <code>global</code> để đánh dấu <code>$x</code> là global variable,
        xem kết quả như thế nào.
      </p>
      <?php
      // Đây là biến global, vì nó nằm ở ngoài cùng của đoạn mã.
      $x = 5;
      $y = 10;

      // Giờ mình sẽ khai báo một function
      function increase_by_100()
      {
        $x = 100;
        $z = 100;
        global $x, $y;

        // Mặc dù $x ban đầu được khai báo là 100, nhưng vì có biến global $x, nên $x = 5
        // Vì thế phép tính sẽ là: 5 + 5 + 10 + 100 = 120.
        $result = $x + $x + $y + $z;

        echo '<p class="font-medium text-red-700">Result: ' . $result . '</p>';
      }

      increase_by_100();
      ?>

      <p>
        Giờ mình đảo ngược lại, cho <code>global</code> lên đầu tiên.
      </p>

      <?php
      // Đây là biến global, vì nó nằm ở ngoài cùng của đoạn mã.
      $x = 5;
      $y = 10;

      // Giờ mình sẽ khai báo một function
      function increase_by_200()
      {
        global $x, $y;
        $x = 200;
        $z = 200;

        // Mặc dù ban đầu $x được khai báo là global, nhưng ở dòng sau thì nó thành local
        // nên $x sẽ bằng 200. Như vậy phép tính sẽ là: 200 + 200 + 10 + 200 = 610.
        $result = $x + $x + $y + $z;

        echo '<p class="font-medium text-red-700">Result: ' . $result . '</p>';
      }

      increase_by_200();
      ?>

      <p>
        Ngoài việc dùng từ khoá <code>global</code> để dùng biến toàn cụ trong scope local ra, thì
        mình còn có thể dùng biến đặc biệt <code>$GLOBALS</code>
      </p>

      <?php
      // Đây là biến global, vì nó nằm ở ngoài cùng của đoạn mã.
      $x = 5;
      $y = 10;

      // Giờ mình sẽ khai báo một function
      function increase_by_300()
      {
        $z = 300;

        $result = $GLOBALS["x"] + $GLOBALS["y"] + $z;

        echo '<p class="font-medium text-red-700">Result: ' . $result . '</p>';
      }

      increase_by_300();
      ?>
    </div>

    <div class="lesson">
      <strong>
        Khái niệm về biến static của PHP nó cũng giống như bao ngôn ngữ khác thôi. Là biến mà
        sẽ được tạo ra từ lúc ban đầu và sẽ không được khai báo, thêm vùng nhớ lại trong vòng
        đời của chương trình.
      </strong>

      <?php
      // Mình sẽ khai báo một biến global static
      static $global_count = 0;

      function my_count()
      {
        static $local_count = 0;

        global $global_count;

        $global_count++;
        $local_count++;

        return $local_count;
      }

      my_count();
      my_count();
      my_count();
      my_count();
      my_count();

      $local_count = my_count();
      $local_count = my_count();

      my_count();

      echo '<p class="font-medium text-red-700">Global Count: ' . $global_count . '</p>';
      echo '<p class="font-medium text-red-700">Local Count: ' . $local_count . '</p>';
      ?>
    </div>
  </div>
</body>