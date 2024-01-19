package com.example.factory;

import com.example.factory.model.*;
import com.example.factory.repository.*;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class MockEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockEcommerceApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(
			ItemRepository itemRepository,
			ReviewRepository reviewRepository
	) {
		Faker faker = new Faker();
		Random random = new Random();
		return args -> {
			try {
//				for (int i = 0; i < 10; i++) {
//					Item item = new Item(
//							faker.commerce().productName(),
//							"../images/random-jacket.jpg",
//							true,
//							random.nextDouble(18, 40),
//							"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
//							50,
//							"Apparel"
//							);
//				}
				Review review1 = reviewRepository.save(new Review(
						"Greg Greggory",
						5,
						"I recently snagged this fantastic sports jacket, and let me tell you, it's a game-changer for my casual chic wardrobe. The sleek design effortlessly combines style and comfort, making it perfect for various occasions. The fabric is top-notch, providing a luxurious feel without compromising on breathability. I'm genuinely impressed with the attention to detail in the stitching; it exudes craftsmanship. The fit is impeccable – not too snug, not too loose – just right for a polished yet relaxed look. The versatility of this jacket is its standout feature; whether I'm heading to a weekend brunch or a casual dinner, it seamlessly elevates my style. Overall, I'd rate it a solid 5 out of 5 for its aesthetic appeal, quality, and adaptability."
				));
				Review review2 = reviewRepository.save(new Review(
						"Jason Bubbles",
						4,
						"This sports jacket has become my go-to for those days when I'm transitioning from the gym to social outings. The moisture-wicking fabric is a game-changer – it keeps me cool and dry after an intense workout. The minimalist design adds a touch of sophistication, making it suitable for grabbing a post-exercise coffee or running errands. The zippered pockets are a thoughtful touch, ensuring that my essentials stay secure. While I appreciate the functionality, the fit could be a tad more tailored for my taste. Nevertheless, it's a reliable piece, earning a solid 4 out of 5 in my book."
				));
				Review review3 = reviewRepository.save(new Review(
						"Mark Trueberry",
						5,
						"As an urban explorer always on the lookout for stylish yet practical apparel, this sports jacket has exceeded my expectations. The urban-inspired design seamlessly blends with my streetwear aesthetic, making it a standout piece in my wardrobe. The lightweight construction allows for easy layering, and the weather-resistant fabric keeps me prepared for unexpected drizzles. The attention-grabbing details, such as the unique zipper placements and color choices, make this jacket a conversation starter. I appreciate the balance between fashion and functionality, earning it a solid 5 out of 5. Whether I'm navigating city streets or catching up with friends, this jacket is a reliable companion that adds an edge to my urban adventures."
				));
				Item item1 = new Item(
								"Jacket",
								"https://pngimg.com/d/jacket_PNG8047.png",
								true,
								random.nextDouble(18, 40),
								"The sports jacket is a versatile and stylish garment, seamlessly blending sophistication with a casual flair. Crafted from high-quality fabrics such as wool, tweed, or cotton, it exudes a refined yet relaxed aesthetic. With a tailored fit, it accentuates the wearer's silhouette, providing both comfort and elegance. Its design often features notched lapels, a single-breasted front, and multiple pockets, adding both functionality and visual interest. Ideal for various occasions, from semi-formal gatherings to outdoor events, the sports jacket effortlessly elevates any ensemble. Whether paired with jeans or dress trousers, this wardrobe essential epitomizes timeless fashion and sartorial versatility.",
								250,
								"apparel"
				);
				review1.setItem(item1);
				review2.setItem(item1);
				review3.setItem(item1);
				item1.getReviews().add(review1);
				item1.getReviews().add(review2);
				item1.getReviews().add(review3);
				itemRepository.save(item1);

				itemRepository.save(new Item(
						"Dress",
						"https://pngimg.com/uploads/dress/dress_PNG115.png",
						true,
						random.nextDouble(18, 40),
						"This enchanting blue dress embodies timeless elegance with a contemporary twist. Crafted from a luxurious, flowing fabric, the dress drapes gracefully, accentuating the wearer's silhouette. The vibrant shade of blue, reminiscent of a clear summer sky, adds a touch of sophistication to any occasion. The fitted bodice features delicate lace detailing, enhancing the dress's feminine allure. A modest neckline transitions seamlessly into a flowing, A-line skirt that gracefully sweeps the floor. The subtle shimmer in the fabric catches the light, creating a subtle play of reflections. This dress is a perfect fusion of classic charm and modern allure.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"T-Shirt",
						"https://www.freeiconspng.com/uploads/blank-t-shirt-png-8.png",
						true,
						random.nextDouble(18, 40),
						"\n" +
								"Introducing our stylish Blue Sky Cotton T-Shirt, a wardrobe essential that effortlessly blends comfort with contemporary flair. Crafted from premium, breathable cotton, this shirt promises a soft touch against your skin, making it perfect for casual outings or laid-back days at home. The vibrant shade of blue adds a refreshing pop of color to your ensemble, enhancing your overall style. The classic crew neckline and short sleeves ensure a timeless silhouette, while the durable fabric maintains its shape wash after wash. Whether paired with jeans for a relaxed look or under a blazer for a smart-casual vibe, this Blue Sky T-Shirt is a versatile must-have.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Sweater",
						"https://www.pngall.com/wp-content/uploads/6/Sweater-PNG-Image.png",
						true,
						random.nextDouble(18, 40),
						"This cozy sweater envelops you in warmth and style, seamlessly blending comfort with fashion. Crafted from a luxurious blend of soft, high-quality materials, it offers a tactile delight against your skin. The fabric drapes effortlessly, creating a flattering silhouette while providing an exquisite feel. The classic crew neckline and ribbed cuffs enhance its timeless appeal, making it a versatile wardrobe staple. Whether you're lounging at home or stepping out into the brisk autumn air, this sweater's exceptional craftsmanship and attention to detail ensure you stay both snug and effortlessly chic. Embrace the season with this essential piece of comfort and elegance.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Shorts",
						"https://www.freepnglogos.com/uploads/shorts-png/pants-swimming-short-png-9.png",
						true,
						random.nextDouble(18, 40),
						"Discover ultimate comfort and style with our versatile shorts. Crafted from breathable, high-quality fabric, these shorts are perfect for any casual occasion. The tailored fit ensures a flattering silhouette, while the elastic waistband provides a customizable and secure fit. Whether you're strolling along the beach or enjoying a weekend brunch, these shorts offer both functionality and fashion. Featuring a classic design with subtle detailing, they effortlessly transition from day to night. Embrace the freedom of movement and express your individuality with this wardrobe essential. Elevate your warm-weather wardrobe with these comfortable and stylish shorts that effortlessly blend fashion and function.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Tank Top",
						"https://www.comegetcustomized.com/media/catalog/product/5/0/500_34.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our sleek and versatile tank top, the epitome of comfort and style. Crafted from a lightweight and breathable blend of cotton and elastane, this tank top ensures optimal comfort for any activity. The classic sleeveless design allows for unrestricted movement, making it perfect for workouts or casual wear. The carefully contoured fit accentuates your physique while providing a relaxed feel. With a ribbed neckline and armholes, this tank top adds a touch of texture to your ensemble. Whether you're hitting the gym, lounging at home, or layering it under a shirt, our tank top effortlessly combines fashion and functionality.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Skirt",
						"https://i.pinimg.com/originals/65/e4/4c/65e44c191055166f7e9c8fa703edbc74.png",
						true,
						random.nextDouble(18, 40),
						"Elevate your style with our exquisite A-line skirt, a versatile wardrobe essential for the modern fashionista. Crafted from premium fabric, the skirt boasts a flattering silhouette that gracefully accentuates curves. The timeless design seamlessly transitions from casual to formal, making it ideal for various occasions. Its mid-length adds a touch of sophistication, while the subtle flare ensures ease of movement. The skirt's impeccable craftsmanship is evident in every detail, from the meticulously stitched seams to the tasteful embellishments. Embrace comfort without compromising on elegance – this A-line skirt effortlessly merges fashion and function, defining a new standard in contemporary chic.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Trousers",
						"https://www.pngall.com/wp-content/uploads/2016/09/Trouser-Free-Download-PNG.png",
						true,
						random.nextDouble(18, 40),
						"\n" +
								"Sure! Here's a 100-word description for a pair of trousers:\n" +
								"\n" +
								"Introducing our sleek and versatile trousers, the epitome of modern style and comfort. Crafted with precision from high-quality, breathable fabric, these trousers seamlessly blend sophistication with practicality. The tailored fit accentuates your silhouette, offering a polished look suitable for any occasion, whether it's a formal meeting or a casual outing. The classic design is complemented by thoughtful details like a secure button and zip closure, ensuring a snug yet comfortable fit. With a timeless appeal and impeccable craftsmanship, these trousers effortlessly elevate your wardrobe, making them a must-have staple for the fashion-conscious individual seeking elegance and ease.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Tophat",
						"https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/048b4913-5180-4a01-8b68-0b9f150c7dfb/d57ouef-c67d0270-4253-4acf-a09f-711468c13a78.png/v1/fill/w_576,h_384/top_hat_png_by_doloresminette_d57ouef-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9Mzg0IiwicGF0aCI6IlwvZlwvMDQ4YjQ5MTMtNTE4MC00YTAxLThiNjgtMGI5ZjE1MGM3ZGZiXC9kNTdvdWVmLWM2N2QwMjcwLTQyNTMtNGFjZi1hMDlmLTcxMTQ2OGMxM2E3OC5wbmciLCJ3aWR0aCI6Ijw9NTc2In1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.dRUCW3wyJ8QK1YsV_-NtSlDegEUNEshTbQQoeukIoJk",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Sneakers",
						"https://png2.cleanpng.com/sh/6d1c6064036732a267e9b18bbafb7c63/L0KzQYm3WcE0N6ZtiJH0aYP2gLBuTfFqel5rhARsZT20PbLwkr1rd6NpedC2c4DygsX6TgNpd5Z4RdDya3Wwf7ftTgdpcaVqRadrOXG5RLO7UsEybGkARqgEM0ezRoKAUcU0Pmk5TKsDMEG2RYi1kP5o/kisspng-air-force-1-air-jordan-sports-shoes-nike-off-white-5b9a64b4211d89.6937061715368449801357.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Glitter Coat",
						"https://therealluxury.com/images/detailed/0/5.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Kimono",
						"https://pngimg.com/d/kimono_PNG19.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Trench Coat",
						"https://pngimg.com/d/coat_PNG33.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Gucci Belt",
						"https://i.pinimg.com/originals/f0/49/21/f049217b6f446e8280be7c8149509893.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Versace Pants",
						"https://img.vitkac.com/uploads/product_thumb/SPODNIE%2075HAA112%20NS304-G89/up/1.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"High Heels",
						"https://www.pngall.com/wp-content/uploads/8/High-Heel-PNG-Image.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Hatsune Miku Cosplay",
						"https://www.youvimi.com/cdn/shop/products/QQ_20210603105308.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Karate Set",
						"https://www.pngitem.com/pimgs/m/46-466231_lightweight-karate-gi-itemprop-thumbnail-data-sizes-karate.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"H&M Winter Jacket",
						"https://www.regattagear.com/helly-hansen/images/33875-CREW-HOODED-JACKET-BLACK-T.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Purse",
						"https://www.pngall.com/wp-content/uploads/5/Purse.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));

					/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Gold Earrings",
						"https://admin.pngadgil1832.com/UploadedFiles/ProductImages/ER14855011PNG_01.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Gold Cuban Chain",
						"https://www.welry.com/globalassets/welry/necklaces/vsc066499y24_a1.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Diamond Cuban Chain",
						"https://thegoldgods.com/cdn/shop/products/Diamond-Cuban-Link-Chain-10mm-Gold-Gods-18k-white-gold-plated-Front-view-Gold-Chain-Mens-Jewelry.png?v=1689258811&width=1080",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Diamond Ring",
						"https://i.pinimg.com/originals/f6/aa/4e/f6aa4e7dfb5711cd66dad999be55f4b6.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Silver Hoop Earrings",
						"https://www.silpada.com/globalassets/products/inv-1tc7-default/p3461_a2.png?format=webp&quality=100&width=300&height=300",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Purple Gold Ring",
						"https://www.treatsstudio.co.uk/cdn/shop/files/treats_ring_9.png?v=1688380199&width=1445",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Platinum Bracelet",
						"https://cdn11.bigcommerce.com/s-j38el1cgyu/images/stencil/1280x1280/products/7444/24353/BD-3540_0__28223.1690339445.png?c=1",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Butterfly Necklace",
						"https://i.pinimg.com/originals/fb/e3/f5/fbe3f5552f8bca53ce13435d232e56da.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"The Witcher's Wolf Emblem Necklace",
						"https://americanwolves.com/cdn/shop/products/The_Witcher_School_of_the_Wolf_Necklace_-_American_Wolves_600x600.png?v=1582641849",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Moon Bracelet",
						"https://manonjewelry.com/wp-content/uploads/2013/11/B-MoonCharmBracelet-43207-web-85.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Spiky Choker",
						"https://i.pinimg.com/originals/c4/a7/8c/c4a78c23735c432884c3c9850b0e14d9.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Yellow Choker",
						"https://i.pinimg.com/originals/f0/96/67/f0966733612c966977c6bdc455ef907b.png", // https://cdn.reddingo.com/assets/product/overview/DC-ZZ-YE.png
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Purple Gold Earrings",
						"https://www.lillianesjewelry.com/wp-content/uploads/101-A2756-1-600x600.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Amethyst Necklace",
						"https://www.lillianesjewelry.com/wp-content/uploads/115-B799-1-copy-600x600.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Rolex",
						"https://files.jewelfeed.com/jewelfeed/catalog/items/156af733-6b91-4fb8-ba43-f8818ae00ab9_WkcMv81.png.800x800_q85_keep_alpha.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Richard Mille Antique Watch",
						"https://imagedelivery.net/lyg2LuGO05OELPt1DKJTnw/1566c4ec-234d-40df-ee99-77de25821000/public",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Gucci Ring",
						"https://itsluxury.com/media/catalog/product/y/b/ybc152045001__1.png?quality=100&fit=bounds&height=&width=",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Chanel Nosering",
						"https://www.chanel.com/images/t_zoomjewelry2/f_auto/lune-single-earring-white-white-gold-diamond-packshot-default-j12120-9529713360926.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Prada Cuban Chain",
						"https://www.prada.com/content/dam/pradanux_products/1/1JC/1JC802/2DTOF0118/1JC802_2DTO_F0118_SLF.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Wizard Sphere Necklace pro ultra series-10",
						"https://chairish-prod.freetls.fastly.net/image/product/master/f534c704-582b-48dd-9e66-9d178462f5ff/crystal-iron-and-crystal-orb-pendant-6278",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewelry"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Monster Energi Drink",
						"https://cleanfoodsmealprep.com/wp-content/uploads/2021/01/Adobe_Post_20210126_2246430.4344855218195506.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Cake",
						"https://static.vecteezy.com/system/resources/thumbnails/027/098/826/small/chocolate-cake-with-berries-isolated-png.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Protein Bar - Chocolate",
						"https://www.pureprotein.com/cdn/shop/files/ppr-126517-1-chocolate-deluxe-50g_1_195a16d0-7628-42f8-9de6-f3580979eecf.png?v=1685123337",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Protein Bar - Vanilla Caramel",
						"https://www.nutramino.com/sites/default/files/styles/large/public/2022-07/Bar-Crispy-van-caramel-1000-1066_0.png?itok=1przEF9S",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Beef Jerky",
						"https://www.jacklinks.com/shop/media/catalog/product/1/0/10000017977_3.25oz_jl_bf_swht_jerk_hero.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Potato Chips - Mexican Fiesta",
						"https://www.kims.no/wp-content/uploads/sites/16/2021/11/Mexican-fiesta.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Potato Chips - Salt % Vinegar",
						"https://image.similarpng.com/very-thumbnail/2021/11/Lay's-Salt-&-Vinegar-Flavored-Potato-Chips-on-transparent-background-PNG.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Candy Mix - 500G",
						"https://image.pngaaa.com/573/3540573-middle.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Whey Protein - Strawberry",
						"https://medievilnutrition.com/cdn/shop/products/wdp_strawberry_delight.png?v=1702294736&width=1000",
						true,
						5999,
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Oreo Cookies - 200G",
						"https://www.cadburygiftsdirect.co.uk/media/catalog/product/cache/d781fed7f79dc069f26dcbeb98b1f140/o/r/oreo-original-154g_3.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Biscuits - 400G",
						"https://assets.stickpng.com/images/580b57fbd9996e24bc43c0fa.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"GFuel Starter Pack - 12 Flavours",
						"https://cdn.shopify.com/s/files/1/0223/3113/files/vbk1.png?v=1702893470",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Taco Spice",
						"https://www.santamariaworld.com/optimized/product-large/globalassets/uk/products/50239.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"FlapJack",
						"https://maxsportnutrition.com/upload/images/category/flapjack.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Organic All-Natural Energy Bar",
						"https://www.outdoorprovisions.co.uk/cdn/shop/products/01.png?v=1665754109",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Milk Chocolate",
						"https://w7.pngwing.com/pngs/415/821/png-transparent-cadbury-dairy-milk-chocolate-cake-chocolate-bar-cadbury-dairy-milk-cocoa-food-cocoa-bean-superfood.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"White Chocolate",
						"https://i.pinimg.com/originals/08/fb/e5/08fbe57c7535c93165a6a764adeec47c.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Midnight Tea",
						"https://www.yogitea.com/site/assets/files/23363/yogi-tea-for-the-senses-good-night-gb-scan.300x0.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Instant Coffee Powder - 300G",
						"https://www.nescafe.com/us/sites/g/files/jgfbjl306/files/gdn_product/field_product_images/nescafe-b150474f7ed01776fa185928e86ef29f2692d9f8.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Liquorice",
						"https://fazerpro.fazer.com/globalassets/remix_salmiakki_230g_404191_web.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"consumable"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Ipad",
						"https://purepng.com/public/uploads/large/purepng.com-ipadelectronicstablet-ipad-941524671278vjvlk.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Macbook Air 2024",
						"https://support.apple.com/library/APPLE/APPLECARE_ALLGEOS/SP825/macbookair.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Lenovo Legion 16 pro",
						"https://ongpng.com/wp-content/uploads/2023/04/3.Lenovo-Legion-Y540-1026x806-1.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"The Beast - Stationary Gaming Computer",
						"https://upload.wikimedia.org/wikipedia/commons/f/f5/Avalanche_Hardline_Liquid_Cooled_Gaming_PC.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"ThinkPad 2022",
						"https://p2-ofp.static.pub/fes/cms/2022/03/21/3ved6sx5xwp6yhl8lbpo42lgxtblqh290202.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Galaxy Tablet S9",
						"https://i0.wp.com/mtcfactoryoutlet.com/wp-content/uploads/2021/08/tab-a7-lite.png?fit=3000%2C2000&ssl=1",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"LG 65\" Oled TV",
						"https://www.vhv.rs/dpng/f/11-119933_lg-oled-tv-png-transparent-png.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Galaxy Phone 23",
						"https://static.vecteezy.com/system/resources/previews/022/722/945/original/samsung-galaxy-s23-ultra-transparent-image-free-png.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Iphone 15 pro max ultra omega",
						"https://storage.googleapis.com/alpine-inkwell-325917.appspot.com/devices/iphone-14-header.png",
						true,
						5999,
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Massage Pistol",
						"https://static.vecteezy.com/system/resources/previews/010/864/665/original/massage-gun-3d-illustration-free-png.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Tesla Optimus - Artificial Intelligence Robot Maid/Butler",
						"https://images.barrons.com/im-477124",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"1440p 240hz Gaming Monitor",
						"https://ongpng.com/wp-content/uploads/2023/03/31.SAMSUNG-_Odyssey_gaiming_monitor_1573x1632.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"4k Oled Ultrawide 144hz Monitor",
						"https://storage.aoc.com/assets/8533/AOC_CU34G2_PV_-FTR-large.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Shure sm7b Microphone",
						"https://products.shureweb.eu/shure_product_db/product_images/files/5d7/cae/9d-/thumb_transparent/2140e6b3255a02c1671635465b5c46f6.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"GoXLR Audio Mixing Board",
						"https://mediadl.musictribe.com/media/PLM/data/images/products/P0CQK/2000Wx2000H/Image_TH_P0CQK_GoXLR_Left_XL.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Sony xm5 Headphones",
						"https://store.sony.co.nz/dw/image/v2/ABBC_PRD/on/demandware.static/-/Sites-sony-master-catalog/default/dw2e089ba5/images/WH1000XM5S/WH1000XM5S.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Apple Airpods Max",
						"https://parspng.com/wp-content/uploads/2023/08/airpodspng.parspng.com-3.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Apple Airpods Pro",
						"https://www.pngall.com/wp-content/uploads/14/Airpod-PNG-Photo.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Earbuds",
						"https://images.samsung.com/is/image/samsung/assets/nz/support/mobile-devices/how-to-activate-samsung-earbuds/1111.png?$ORIGIN_PNG$",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Meta Quest 3",
						"https://www.synergiz.com/wp-content/uploads/2023/10/meta-quest-3.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Gardening Gloves",
						"https://i.pinimg.com/originals/90/3d/9d/903d9df97b3adcc1d45a6ca0a16651b2.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Pruning Shears",
						"https://cpimg.tistatic.com/05429902/b/4/Pruning-Shear-Agriculture-Tools-.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Watering Can",
						"https://gallery.yopriceville.com/var/resizes/Free-Clipart-Pictures/Spring-PNG/Watering_Can_PNG_Clip_Art_Image.png?m=1517889302",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Soil Moisture Meter",
						"https://my.mouser.com/images/marketingid/2018/img/112439723_Sparkfun_Soil%20Moisture%20Sensor%20with%20Screw%20Terminals.png?v=070223.0511",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Plant Pot",
						"https://purepng.com/public/uploads/large/purepng.com-flower-potflower-object-gardening-pot-terracotta-plastic-garden-961524680055ywhu0.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Fertilizer",
						"https://www.unikeyterra.com/wp-content/uploads/2020/01/Unikey-AN-33-Ammonium-Nitrate.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Trowel",
						"https://freepngimg.com/thumb/tools/175191-garden-trowel-free-transparent-image-hq.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Rake",
						"https://pngimg.com/d/rake_PNG32.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Gardening Knee Pads",
						"https://c-pf.niceshops.com/upload/image/product/large/default/esschert-design-knee-pads-1351672-en.png",
						true,
						5999,
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Composite Bin",
						"https://res.cloudinary.com/hksqkdlah/image/upload/ATK%20Reviews/2022/Compost%20Bins/SIL_Exaco_Eco-2000-Kitchen-Compost-Pail_2000.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Sprayer",
						"https://www.holmanindustries.com.au/wp-content/uploads/GC8050-EzySpray-5L-Pump-Free-Garden-Sprayer-3.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Plant Markers",
						"https://seed2plant.in/cdn/shop/products/PhotoRoom_20210920_160829.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Insect Netting",
						"https://nunababy.eu/pub/media/catalog/product/s/i/sizedsena_insect_net_beauty_1__7ffb.png?type=product&height=400&width=400",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Solar Powered Garden Lights",
						"https://products.shureweb.eu/shure_product_db/product_images/files/5d7/cae/9d-/thumb_transparent/2140e6b3255a02c1671635465b5c46f6.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Wheelbarrow",
						"https://pngimg.com/d/wheelbarrow_PNG12.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Rain Barrel",
						"https://pngimg.com/d/wheelbarrow_PNG12.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Kneeler",
						"https://primestashstore.com/cdn/shop/products/2_ad9062ee-cdf3-4938-958d-8a5ba0ffa3da_800x.png?v=1619204595",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Weeder",
						"https://png.pngtree.com/png-vector/20230426/ourmid/pngtree-reflective-automatic-weeder-png-image_6734400.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Trellis",
						"https://lancastersonline.com/cdn/shop/products/Trellis_big_web.png?v=1677164785",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Sprinkler",
						"https://static.wixstatic.com/media/541ad8_0c0d7b1c6a5f4317aef128d470b12673~mv2.png/v1/fill/w_480,h_316,al_c,lg_1,q_85,enc_auto/water%20sprinkler.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"gardening"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Cloud Sofa",
						"https://i.pinimg.com/originals/53/d8/82/53d882b543326bfa86515e736b6e054b.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Dining Table",
						"https://freepngimg.com/download/dining_table/4-2-dining-table-transparent.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Chair",
						"https://pngimg.com/d/chair_PNG6847.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Bed",
						"https://pngimg.com/d/bed_PNG17418.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Wardrobe",
						"https://i.pinimg.com/originals/08/ba/ca/08bacad019414e3eea1ad2c449f0a1a9.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Bookshelf",
						"https://areastore.com/cdn/shop/files/57387_300x.png?v=1697039968",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Desk",
						"https://assets.stickpng.com/images/5a058d929cf05203c4b603fe.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Night Stand",
						"https://www.pngall.com/wp-content/uploads/5/Wooden-Night-Table-PNG-Image.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Armchair",
						"https://i.pinimg.com/originals/54/1d/d4/541dd467d515c5b93a024391eb3f0796.png",
						true,
						5999,
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Cupboard",
						"https://purepng.com/public/uploads/large/purepng.com-cupboardcupboardpressa-cabinetdoor-and-shelves-1701527921934nsnco.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"TV stand",
						"https://t3.ftcdn.net/jpg/06/16/26/16/360_F_616261662_4b1CL8G1G0orM8Pl9vcX1M1ZREKbqL3a.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Coffee Table",
						"https://floydhome.com/cdn/shop/products/Coffee_Default_Birch-Black.0001.png?v=1613585906",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Carpet",
						"https://pngimg.com/d/carpet_PNG19.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Mirror",
						"https://purepng.com/public/uploads/large/purepng.com-mirrormirrorspeculumlookinlooking-glass-1701527941267fodjo.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Chest",
						"https://pngimg.com/uploads/treasure_chest/treasure_chest_PNG157.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Chest of Drawers",
						"https://pngimg.com/d/dresser_PNG159.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Futon",
						"https://freepngimg.com/download/aquarium/43451-9-futon-free-photo-png.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Dresser",
						"https://www.pngall.com/wp-content/uploads/3/Dresser-PNG-Free-Download.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Mannequin",
						"https://static.vecteezy.com/system/resources/thumbnails/018/875/006/small/body-anatomy-isolated-on-background-free-png.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Ottoman",
						"https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-ottoman-and-pouf-3d-render-png-image_10165345.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
			} catch(Exception e) {
				e.printStackTrace();
			}
		};
	}
}
