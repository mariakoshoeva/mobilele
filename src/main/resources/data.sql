INSERT INTO mobilele.brands (id, created, modified, name)
VALUES (1, '2022-05-25 20:10:25', '2022-05-25 20:10:29', 'BMW');
INSERT INTO mobilele.brands (id, created, modified, name)
VALUES (2, '2022-05-25 20:10:45', '2022-05-25 20:10:47', 'Mercedes-Benz');

INSERT INTO mobilele.models (id, created, modified, category, end_year, image_url, name, start_year, brand_id)
VALUES (1, '2022-06-14 19:02:55', '2022-06-14 19:03:00', 'CAR', null,
        'https://www.bmw.bg/content/dam/bmw/common/all-models/i-series/i3/2021/highlights/bmw-i3-gallery-image-design-02_1920.jpg.asset.1634821759030.jpg',
        'BMV i3', 2013, 1);
INSERT INTO mobilele.models (id, created, modified, category, end_year, image_url, name, start_year, brand_id)
VALUES (2, '2022-06-14 19:11:06', '2022-06-14 19:11:10', 'CAR', null,
        'https://www.mercedes-benz.bg/passengercars/mercedes-benz-cars/models/eqc/design/line-details/_jcr_content/contentgallerycontainer/par/contentgallery_55cc/par/contentgallerytile_f/image.MQ6.6.20210108133021.jpeg',
        'EQC', 2019, 2);

INSERT INTO mobilele.roles (id, name)
 VALUES (1, 'USER');
INSERT INTO mobilele.roles (id, name)
VALUES (2, 'ADMIN');