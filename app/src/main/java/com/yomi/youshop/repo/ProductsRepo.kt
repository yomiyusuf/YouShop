package com.yomi.youshop.repo

import com.yomi.youshop.model.Product
import java.math.BigDecimal

class ProductsRepo {

    fun getProducts(): ArrayList<Product> {
        return arrayListOf(
            Product(1, "Nintento switch", "Play your favourite games anytime, anywhere, with anyone, with Nintendo Switch", BigDecimal(400.0), null, "https://www.radio-rentals.com.au/media/catalog/product/cache/8872124951f387c8ded3f228faa55bea/g/a/ga4000-4-web.jpg"),
            Product(2, "iPhone Xs Max", "iPhone XS is everything you love about iPhone. Taken to the extreme.", BigDecimal(2000.0), BigDecimal(2050.0), "https://images-na.ssl-images-amazon.com/images/I/61pu8v9oXrL._SX569_.jpg"),
            Product(3, "Pixel 3 XL", "Pixel 3 and Pixel 3 XL are everything you wish your phone could do. Brilliant camera, all day battery, and Google Assistant with a squeeze", BigDecimal(1500.0), null, "https://r3.whistleout.com.au/public/images/articles/2018/10/p3_hero.jpg"),
            Product(4, "Sony Alpha 7 III R", "Sony's latest A7 series cameras combine high resolution with high speed and professional performance", BigDecimal(5000.0), BigDecimal(6000.0), "https://sm.pcmag.com/t/pcmag_au/photo/f/front/front_2cx3.1080.jpg"),
            Product(5, "Leica M10", "When you take a photograph with a Leica M-System camera, you experience a different kind of photography.", BigDecimal(10300.0), null, "https://assets.pcmag.com/media/images/524154-leica-m10-d.jpg?width=810&height=456"),
            Product(6, "Apple AirPods", "With 24-hour battery life and groundbreaking ease of use and intelligence, AirPods are wireless headphones unlike any other.", BigDecimal(200.0), BigDecimal(250.0), "https://icdn2.digitaltrends.com/image/apple-airpods-gen-2_7-640x640.jpg"),
            Product(7, "Sennheiser PXC550", "Superior quality headphones with top level of comfort, deep sound and compactness", BigDecimal(430.0), null, "https://icdn3.digitaltrends.com/image/poster-for-5717666834001-2-720x720.jpg"),
            Product(8, "B&W PX", "Great noise cancelling, bluetooth capabilities and sound quality", BigDecimal(550.0), null, "https://ksassets.timeincuk.net/wp/uploads/sites/54/2017/10/Bowers-Wilkins-BW-PX_3-920x613.jpg"),
            Product(9, "AudioQuest Nighthawk", "Sophisticated bio-friendly Headphone with style, luxurious comfort and high quality sound.", BigDecimal(1000.0), null, "https://cdn.head-fi.org/a/9826760.jpg"),
            Product(10, "HHKB Pro 2", "A movement, redefining what a professional keyboard", BigDecimal(500.0),null, "https://media.karousell.com/media/photos/products/2019/02/18/hhkb_pro_2_white_1550501070_3181c1eb.jpg"),
            Product(11, "Ergodox EZ", "An open-source keyboard for serious developers, gamers, and people who care deeply about their craft.", BigDecimal(1350.0), null, "https://thegadgetflow.com/wp-content/uploads/2016/07/ErgoDox-EZ-Ergonomic-Mechanical-Keyboard-04.jpg"),
            Product(12, "X-Bows Ergonomic", "Ergo mech keyboard that great for long days at work and intense gaming sessions", BigDecimal(170.0), BigDecimal(200.0), "https://apollo-ireland.akamaized.net/v1/files/v8ceq3msoxgh3-ZA/image;s=850x0")
        )
    }
}