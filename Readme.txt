Setting project:
    - Trong file application.properties (trong src/main/resource):
        + Thay thông tin database: username, password, link database
    - Trong file FileStore (trong src/main/com.tungx.demoapi.controller)
        + Cập nhật đường dẫn của thư mục chứa ảnh các món ăn.
API:
lấy đường dẫn trong các file code ở src/main/com.tungx.demoapi.controller
    Món ăn:
        - Lấy tất cả món ăn
            .../api/monan/monans
            respone body: json
        - Lấy món ăn theo chuyên mục, x là id chuyên mục
            /api/monan/monansbychuyenmuc?idcm=x
            respone body: json
        - Lấy món ăn theo chuyên mục
            /api/monan/monansbychuyenmuc
            request body: truyền vào 1 số dạng json
            respone body: json
        - Tìm kiếm món ăn (theo tên): x là String truyền vào, có thể viết tiếng việt, tìm khi có từ 2 kí tự trở lên
            /api/monan/monansbyten?ten=x
        - Tìm kiếm món ăn (theo tên):
            /api/monan/monansbyten1
            request body: json
            respone body: json
        - Link ảnh:
            /api/monan/image/tên ảnh