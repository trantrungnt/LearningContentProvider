# Learning ContentProvider
+ [Nguồn tham khảo xem tại đây](https://laptrinhtuduy.wordpress.com/2014/04/28/content-providers-trong-android/)
+ [Xem cách sử dụng SQLITE trong Android](https://duythanhcse.wordpress.com/2013/06/12/bai-tap-31-cach-su-dung-sqlite-trong-android/)

##Tạo Content Provider
Content Provider sẽ kế thừa class ContentProvider và phải implement một chuẩn tập các APIs để cho phép các ứng dụng khác thực hiện xử lý các giao dịch.

```java
public class MyContentProvider extends  ContentProvider {
 
}
```

##Content URIs
Để truy vấn một Content Provider, bạn chỉ định chuỗi truy vấn theo hình thức của một URI  theo định dạng sau:
```java
<prefix>://<authority>/<data_type>/<id>
```

+ **prefix**: Nó luôn được thiết lập là content://
+ **authority**: Chỉ định tên cụ thể của Content Provider (VD: contacts, browser,…). Đối với một số Content Provider khác bạn sẽ phải chỉ định tên đầy đủ (VD: com.laptrinhtuduy.statusprovider).
+ **data_type**: Chỉ rõ kiểu dữ liệu (VD: Để lấy tất cả các liên hệ trong Contacts Content Provider thì kiểu dữ liệu là people và URI sẽ là: content://contacts/people.
+ **id**: Chỉ định rõ một record (VD: Nếu bạn muốn lấy địa chỉ liên lạc thứ 5 trong Contacts Content Provider thì URI sẽ là: content://contacts/people/5.

##Một số bước đơn giản để tạo Content Provider riêng của bạn:

Đầu tiên cần tạo một class Content Provider kế thừa class ContentProviderbase.
Bạn cần định nghĩa địa chỉ URI cho Content Provider của bạn, nó sẽ được dùng để truy xuất nội dung.
Bạn cần tạo một CSDL của riêng bạn để lưu các Content. Thông thường, Android sử dụng CSDL SQLite, cần phải Override phương thức onCreate() nó sẽ sử dụng phương thức SQLite Open Helper để tạo hoặc mở CSDL của provider. Khi ứng dụng của bạn khởi chạy, phương thức onCreate() sẽ xử lý các Content Providers của nó.
Tiếp theo cần phải implement các truy vấn của Content Provider để xử lý các yêu cầu khác nhau về dữ liệu.
Cuối cùng, đăng ký Content Provider của bạn bằng cách sử dụng nhãn <provider>.
Các phương thức cần được Override trong lớp Content Provider:

+ **onCreate()**: Phương thức này được gọi khi Provider được bắt đầu.
+ **query()**: Phương thức nhận yêu cầu từ Client. Kết quả được trả về như một đối tượng Cursor.
+ **insert()**: Phương thức chèn một dòng dữ liệu mới vào Content Provider.
+ **delete()**: Phương thức xóa một dòng dữ liệu đã tồn tại.
+ **update()**: Phương thức cập nhật một dòng dữ liệu nào đó đã tồn tại.
+ **getType()**: Phương thức trả về kiểu MIME của dữ liệu tại các URI.