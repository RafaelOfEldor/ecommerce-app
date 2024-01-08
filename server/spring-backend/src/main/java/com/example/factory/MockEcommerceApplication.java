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
							"../images/random-jacket.jpg",
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
				new Item(
						"Skirt",
						"https://assets.stickpng.com/images/580b57fbd9996e24bc43bf70.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				);
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
				new Item(
						"Hatsune Cosplay",
						"https://www.youvimi.com/cdn/shop/products/QQ_20210603105308.png",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"apparel"
				);
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
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Gold Cuban Chain",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Diamond Cuban Chain",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Diamond Ring",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Silver Hoop Earrings",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Purple Gold Ring",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				new Item(
						"Platinum Bracelet",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				);
				itemRepository.save(new Item(
						"Butterfly Necklace",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"The Witcher's Wolf Emblem Necklace",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Full Moon Bracelet",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Spikey Choker",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Yellow Choker",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Purple Gold Earrings",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Amethyst Necklace",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Rolex",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Richard Mille Antique Watch",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				new Item(
						"Gucci Ring",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				);
				itemRepository.save(new Item(
						"Chanel Nosering",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Prada Cuban Chain",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));
				itemRepository.save(new Item(
						"Wizard Sphere Necklace pro ultra series-10",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"jewlery"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Ipad",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Macbook Air 2024",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Lenovo Legion 16 pro",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"The Beast - Stationary Gaming Computer",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"ThinkPad 2022",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Galaxy Tablet S9",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				new Item(
						"LG 65\" Oled TV",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				);
				itemRepository.save(new Item(
						"Samsung Galaxy Phone 23",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Iphone 15 pro max ultra omega",
						"../images/random-jacket.jpg",
						true,
						5999,
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Massage Pistol",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Tesla Optimus - Artificial Intelligence Robot Maid/Butler",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"1440p 240hz Gaming Monitor",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"4k Oled Ultrawide 144hz Monitor",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Shure sm7b Microphone",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"GoXLR Audio Mixing Board",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Sony xm5 Headphones",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				new Item(
						"Apple Airpods Max",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				);
				itemRepository.save(new Item(
						"Apple Airpods Pro",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Earbuds",
						"../images/random-jacket.jpg",
						true,
						random.nextDouble(18, 40),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Meta Quest 3",
						"../images/random-jacket.jpg",
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
