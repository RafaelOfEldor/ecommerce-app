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
			ItemRepository itemRepository
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
				itemRepository.save(new Item(
							"Jacket",
							"https://pngimg.com/d/jacket_PNG8047.png",
							true,
							random.nextDouble(18, 40),
							"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
							250,
							"apparel"
							));
				itemRepository.save(new Item(
						"Dress",
						"https://pngimg.com/uploads/dress/dress_PNG115.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"T-Shirt",
						"https://pics.clipartpng.com/Blue_T_Shirt_PNG_Clipart-2346.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Sweater",
						"https://www.pngall.com/wp-content/uploads/6/Sweater-PNG-Image.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Shorts",
						"https://assets.stickpng.com/thumbs/580b57fbd9996e24bc43bf61.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Tank Top",
						"https://www.comegetcustomized.com/media/catalog/product/5/0/500_34.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Skirt",
						"https://assets.stickpng.com/images/580b57fbd9996e24bc43bf70.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Trousers",
						"https://www.pngall.com/wp-content/uploads/2016/09/Trouser-Free-Download-PNG.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
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
						"jewlery"
				));
				itemRepository.save(new Item(
						"Gold Cuban Chain",
						"https://www.welry.com/globalassets/welry/necklaces/vsc066499y24_a1.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Diamond Cuban Chain",
						"https://thegoldgods.com/cdn/shop/products/Diamond-Cuban-Link-Chain-10mm-Gold-Gods-18k-white-gold-plated-Front-view-Gold-Chain-Mens-Jewelry.png?v=1689258811&width=1080",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Diamond Ring",
						"https://i.pinimg.com/originals/f6/aa/4e/f6aa4e7dfb5711cd66dad999be55f4b6.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Silver Hoop Earrings",
						"https://www.silpada.com/globalassets/products/inv-1tc7-default/p3461_a2.png?format=webp&quality=100&width=300&height=300",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Purple Gold Ring",
						"https://www.treatsstudio.co.uk/cdn/shop/files/treats_ring_9.png?v=1688380199&width=1445",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Platinum Bracelet",
						"https://cdn11.bigcommerce.com/s-j38el1cgyu/images/stencil/1280x1280/products/7444/24353/BD-3540_0__28223.1690339445.png?c=1",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Butterfly Necklace",
						"https://i.pinimg.com/originals/fb/e3/f5/fbe3f5552f8bca53ce13435d232e56da.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"The Witcher's Wolf Emblem Necklace",
						"https://americanwolves.com/cdn/shop/products/The_Witcher_School_of_the_Wolf_Necklace_-_American_Wolves_600x600.png?v=1582641849",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Moon Bracelet",
						"https://manonjewelry.com/wp-content/uploads/2013/11/B-MoonCharmBracelet-43207-web-85.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Spiky Choker",
						"https://i.pinimg.com/originals/c4/a7/8c/c4a78c23735c432884c3c9850b0e14d9.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Yellow Choker",
						"https://i.pinimg.com/originals/f0/96/67/f0966733612c966977c6bdc455ef907b.png", // https://cdn.reddingo.com/assets/product/overview/DC-ZZ-YE.png
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Purple Gold Earrings",
						"https://www.lillianesjewelry.com/wp-content/uploads/101-A2756-1-600x600.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Amethyst Necklace",
						"https://www.lillianesjewelry.com/wp-content/uploads/115-B799-1-copy-600x600.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Rolex",
						"https://files.jewelfeed.com/jewelfeed/catalog/items/156af733-6b91-4fb8-ba43-f8818ae00ab9_WkcMv81.png.800x800_q85_keep_alpha.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Richard Mille Antique Watch",
						"https://imagedelivery.net/lyg2LuGO05OELPt1DKJTnw/1566c4ec-234d-40df-ee99-77de25821000/public",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Gucci Ring",
						"https://itsluxury.com/media/catalog/product/y/b/ybc152045001__1.png?quality=100&fit=bounds&height=&width=",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Chanel Nosering",
						"https://www.chanel.com/images/t_zoomjewelry2/f_auto/lune-single-earring-white-white-gold-diamond-packshot-default-j12120-9529713360926.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Prada Cuban Chain",
						"https://www.prada.com/content/dam/pradanux_products/1/1JC/1JC802/2DTOF0118/1JC802_2DTO_F0118_SLF.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Wizard Sphere Necklace pro ultra series-10",
						"https://chairish-prod.freetls.fastly.net/image/product/master/f534c704-582b-48dd-9e66-9d178462f5ff/crystal-iron-and-crystal-orb-pendant-6278",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
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
			} catch(Exception e) {
				e.printStackTrace();
			}
		};
	}
}
