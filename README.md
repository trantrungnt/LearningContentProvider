# LearningContentProvider
[Tham khảo tại đây](https://laptrinhtuduy.wordpress.com/2014/04/28/content-providers-trong-android/)

#Tạo Content Provider

##Một số bước đơn giản để tạo Content Provider riêng của bạn:

Đầu tiên cần tạo một class Conten Provider kế thừa class ContentProviderbase.
Bạn cần định nghĩa địa chỉ URI cho Content Provider của bạn, nó sẽ được dùng để truy xuất nội dung.
Bạn cần tạo một CSDL của riêng bạn để lưu các Content. Thông thường, Android sử dụng CSDL SQLite, cần phải Override phương thức onCreate() nó sẽ sử dụng phương thức SQLite Open Helper để tạo hoặc mở CSDL của provider. Khi ứng dụng của bạn khởi chạy, phương thức onCreate() sẽ xử lý các Content Providers của nó.
Tiếp theo cần phải implement các truy vấn của Content Provider để xử lý các yêu cầu khác nhau về dữ liệu.
Cuối cùng, đăng ký Content Provider của bạn bằng cách sử dụng nhãn <provider>.
Các phương thức cần được Override trong lớp Content Provider:

+ onCreate(): Phương thức này được gọi khi Provider được bắt đầu.
+ query(): Phương thức nhận yêu cầu từ Client. Kết quả được trả về như một đối tượng Cursor.
+ insert(): Phương thức chèn một dòng dữ liệu mới vào Content Provider.
+ delete(): Phương thức xóa một dòng dữ liệu đã tồn tại.
+ update(): Phương thức cập nhật một dòng dữ liệu nào đó đã tồn tại.
+ getType(): Phương thức trả về kiểu MIME của dữ liệu tại các URI.