package com.mock_ecommerce_app;

import com.github.javafaker.Faker;
import com.mock_ecommerce_app.model.Item;
import com.mock_ecommerce_app.model.Review;
import com.mock_ecommerce_app.repository.ItemRepository;
import com.mock_ecommerce_app.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
						"Introducing our sleek and versatile trousers, the epitome of modern style and comfort. Crafted with precision from high-quality, breathable fabric, these trousers seamlessly blend sophistication with practicality. The tailored fit accentuates your silhouette, offering a polished look suitable for any occasion, whether it's a formal meeting or a casual outing. The classic design is complemented by thoughtful details like a secure button and zip closure, ensuring a snug yet comfortable fit. With a timeless appeal and impeccable craftsmanship, these trousers effortlessly elevate your wardrobe, making them a must-have staple for the fashion-conscious individual seeking elegance and ease.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Tophat",
						"https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/048b4913-5180-4a01-8b68-0b9f150c7dfb/d57ouef-c67d0270-4253-4acf-a09f-711468c13a78.png/v1/fill/w_576,h_384/top_hat_png_by_doloresminette_d57ouef-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9Mzg0IiwicGF0aCI6IlwvZlwvMDQ4YjQ5MTMtNTE4MC00YTAxLThiNjgtMGI5ZjE1MGM3ZGZiXC9kNTdvdWVmLWM2N2QwMjcwLTQyNTMtNGFjZi1hMDlmLTcxMTQ2OGMxM2E3OC5wbmciLCJ3aWR0aCI6Ijw9NTc2In1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.dRUCW3wyJ8QK1YsV_-NtSlDegEUNEshTbQQoeukIoJk",
						true,
						random.nextDouble(18, 40),
						"The top hat, a timeless and distinguished accessory, embodies an air of elegance and sophistication. Crafted from quality materials such as felt or silk, its tall and cylindrical crown, complemented by a flat brim, grants the wearer an instant touch of refinement. Originating in the 18th century, the top hat became synonymous with formal occasions and upper-class attire. Whether donned by Victorian gentlemen or modern fashion enthusiasts, this iconic headpiece exudes an aura of grace and tradition. Pair it with formal attire for a classic, debonair look or use it as a whimsical statement piece in contemporary fashion.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Sneakers",
						"https://static.vecteezy.com/system/resources/previews/030/761/291/non_2x/modern-sport-sneakers-blue-color-ai-generative-free-png.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our latest sneakers, a pinnacle of style and comfort. Crafted with precision, these shoes seamlessly blend fashion-forward design with cutting-edge technology. The sleek silhouette and dynamic color palette make a bold statement, ensuring you stand out in any crowd. The breathable mesh upper provides optimal ventilation, while the cushioned insole guarantees a plush and responsive feel with every step. Whether you're hitting the gym, running errands, or simply navigating the urban landscape, these sneakers offer unparalleled support and flexibility. Elevate your footwear game with this fusion of contemporary aesthetics and unparalleled functionality—a true embodiment of modern athleticism.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Glitter Coat",
						"https://therealluxury.com/images/detailed/0/5.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our dazzling Glitter Coat, a transformative touch for your surfaces. This unique coating seamlessly combines functionality with glamour, infusing any item with a radiant, shimmering allure. Ideal for furniture, home decor, or accent pieces, the Glitter Coat adds a touch of sophistication and contemporary flair. The ultra-fine glitter particles create a mesmerizing effect, catching and reflecting light to create an ever-changing, ethereal appearance. Whether applied to wooden furniture or decorative accessories, this coating not only provides a protective layer but also elevates the aesthetic, turning ordinary surfaces into extraordinary focal points. Embrace the magic of glitter and redefine your living space.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Kimono",
						"https://pngimg.com/d/kimono_PNG19.png",
						true,
						random.nextDouble(18, 40),
						"A kimono is a traditional Japanese garment known for its timeless elegance. Crafted from luxurious silk or cotton fabrics, it features wide sleeves and a T-shaped silhouette, creating a graceful and flowing appearance. The intricate designs, often inspired by nature, folklore, or geometric patterns, are meticulously embroidered or dyed. Kimonos are versatile, serving as both formal attire for special occasions and casual wear. They are secured with an obi, a wide sash, accentuating the waist. Beyond its aesthetic allure, the kimono embodies cultural richness, embodying centuries-old traditions. Worn with grace, it symbolizes both fashion and a deep respect for Japanese heritage.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Trench Coat",
						"https://pngimg.com/d/coat_PNG33.png",
						true,
						random.nextDouble(18, 40),
						"The epitome of timeless elegance, our trench coat seamlessly blends style and functionality. Crafted from water-resistant fabric, this iconic outerwear piece embraces the classic double-breasted silhouette with a belted waist for a tailored fit. Its versatile design effortlessly transitions from casual to formal, making it a staple for any wardrobe. The notched collar and shoulder epaulets add a touch of sophistication, while the adjustable cuffs allow for personalized comfort. Equally at home in urban streets or countryside strolls, this trench coat is a sartorial essential that withstands trends, providing enduring style for the modern, discerning individual.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Gucci Belt",
						"https://i.pinimg.com/originals/f0/49/21/f049217b6f446e8280be7c8149509893.png",
						true,
						random.nextDouble(18, 40),
						"The Gucci Belt embodies timeless luxury and iconic style. Crafted with precision from supple, high-quality leather, the belt showcases the brand's unmistakable double-G logo as a statement of sophistication. The classic interlocking G buckle, meticulously designed with attention to detail, adds a touch of opulence to any ensemble. Versatile and effortlessly chic, this accessory seamlessly elevates both casual and formal looks. The rich craftsmanship and signature Gucci flair make it a symbol of refined taste, ensuring a bold fashion statement. Elevate your wardrobe with this exquisite piece that harmonizes with the brand's legacy of elegance and prestige.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Versace Pants",
						"https://img.vitkac.com/uploads/product_thumb/SPODNIE%2075HAA112%20NS304-G89/up/1.png",
						true,
						random.nextDouble(18, 40),
						"Introducing the epitome of luxury in fashion – Versace Pants. Crafted with meticulous attention to detail, these trousers seamlessly blend opulence with contemporary style. The fabric, a testament to Versace's commitment to quality, drapes elegantly, ensuring a perfect fit and unparalleled comfort. The iconic Medusa head emblem discreetly adorns the waistband, symbolizing the brand's heritage and sophistication. With a tailored silhouette and precision tailoring, Versace Pants effortlessly elevate any ensemble, whether for a formal affair or a high-profile event. Embrace the allure of Italian couture, as these pants redefine glamour and make an unmistakable statement in the world of high fashion.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"High Heels",
						"https://www.pngall.com/wp-content/uploads/8/High-Heel-PNG-Image.png",
						true,
						random.nextDouble(18, 40),
						"Elevate your style with these glamorous high heels that effortlessly blend sophistication and allure. Crafted with precision, the sleek stiletto design accentuates your silhouette, elongating your legs for a captivating stride. The rich, faux leather exterior exudes luxury, while the pointed toe adds a touch of elegance. Padded insoles ensure comfort for extended wear, making them perfect for both formal occasions and nights on the town. The adjustable ankle strap provides a secure fit, while the bold heel height adds a dash of confidence to your ensemble. Step into fashion-forward femininity with these high heels, the epitome of timeless glamour.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Hatsune Miku Cosplay",
						"https://i.pinimg.com/736x/83/03/8e/83038e5e4256ac2b8691c39d8afc5868.jpg",
						true,
						random.nextDouble(18, 40),
						"Introducing the ultimate Hatsune Miku cosplay kit, a meticulously crafted ensemble for fans to embody the iconic virtual pop sensation. This kit encapsulates Miku's signature look, featuring a vibrant turquoise wig with her distinctive twin-tails, perfectly emulating her futuristic persona. The costume is a meticulous replica, mirroring Miku's recognizable sleeveless top, tie, and pleated skirt adorned with digital motifs. Accessorize with thigh-high stockings, armbands, and the unmistakable Vocaloid headset to complete the transformation. Designed for both authenticity and comfort, this Hatsune Miku cosplay kit invites enthusiasts to step into the virtual limelight and celebrate the unique charm of this beloved digital diva.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Karate Set",
						"https://www.pngitem.com/pimgs/m/46-466231_lightweight-karate-gi-itemprop-thumbnail-data-sizes-karate.png",
						true,
						random.nextDouble(18, 40),
						"\n" +
								"The Karate Suit, also known as a Gi, is a traditional martial arts uniform designed for practitioners of karate. Typically composed of a jacket, pants, and a belt, the Karate Suit emphasizes functionality, durability, and a respectful representation of the art. Crafted from sturdy cotton or a cotton-blend fabric, the Gi withstands the rigors of training and provides optimal comfort. The loose-fitting design allows for unrestricted movement during kicks, punches, and other techniques. The belt, often color-coded to indicate the wearer's rank, symbolizes the journey and progression within the discipline. A Karate Suit embodies the essence of martial arts training, blending form and function seamlessly.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"H&M Winter Jacket",
						"https://www.regattagear.com/helly-hansen/images/33875-CREW-HOODED-JACKET-BLACK-T.png",
						true,
						random.nextDouble(18, 40),
						"Introducing the H&M Winter Jacket – a fusion of style and warmth for the cold season. This contemporary piece is crafted with precision, featuring a durable outer shell that effortlessly repels winter's chill. The jacket boasts a sleek design, tailored for both fashion and functionality. Its insulated interior ensures optimal comfort, while the adjustable hood and cuffs provide customizable protection against the elements. The H&M Winter Jacket is not just a shield against the cold; it's a fashion statement. With a versatile color palette and modern cut, this jacket seamlessly complements any winter wardrobe, promising a cozy and on-trend winter experience.",
						250,
						"apparel"
				));
				itemRepository.save(new Item(
						"Purse",
						"https://www.pngall.com/wp-content/uploads/5/Purse.png",
						true,
						random.nextDouble(18, 40),
						"Introducing the epitome of sophistication and functionality, our exquisite purse seamlessly marries style with practicality. Crafted from supple, high-quality leather, its luxurious texture enhances both tactile pleasure and visual allure. The meticulously designed interior features multiple compartments, providing ample space for your essentials while maintaining organizational efficiency. The elegant, timeless silhouette is adorned with subtle, tasteful embellishments, adding a touch of understated glamour to any ensemble. With a secure closure and adjustable strap for versatile carrying options, this purse effortlessly transitions from day to night, making it the perfect accessory for those who appreciate refined elegance and practical design.",
						250,
						"apparel"
				));

					/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Gold Earrings",
						"https://admin.pngadgil1832.com/UploadedFiles/ProductImages/ER14855011PNG_01.png",
						true,
						random.nextDouble(18, 10000),
						"Gold earrings are exquisite accessories that effortlessly blend elegance and style. Crafted from the lustrous precious metal, these earrings showcase timeless beauty. The radiant allure of gold adds a touch of luxury to any ensemble, making them a versatile choice for both casual and formal occasions. Whether adorned with intricate designs, gemstones, or simple geometric shapes, gold earrings capture attention and elevate the wearer's aesthetic. Their enduring appeal makes them cherished pieces in jewelry collections, symbolizing sophistication and refinement. Whether as a gift or a personal indulgence, gold earrings remain a timeless expression of enduring beauty and classic fashion.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Gold Cuban Chain",
						"https://www.welry.com/globalassets/welry/necklaces/vsc066499y24_a1.png",
						true,
						random.nextDouble(18, 10000),
						"Introducing our exquisite Gold Cuban Chain, a timeless symbol of opulence and sophistication. Crafted with precision, each link boasts a lustrous 18-karat gold finish, ensuring a radiant allure that transcends trends. The classic Cuban link design, renowned for its robust and intricate interlocking pattern, enhances the chain's substantial weight and luxurious feel. Meticulously polished to achieve a flawless gleam, this accessory seamlessly transitions from casual elegance to upscale charm. Whether worn solo or layered, the Gold Cuban Chain is a statement of refined taste and enduring style, a manifestation of uncompromising quality for those who appreciate the finer things in life.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Diamond Cuban Chain",
						"https://thegoldgods.com/cdn/shop/products/Diamond-Cuban-Link-Chain-10mm-Gold-Gods-18k-white-gold-plated-Front-view-Gold-Chain-Mens-Jewelry.png?v=1689258811&width=1080",
						true,
						random.nextDouble(18, 10000),
						"Introducing the epitome of opulence and style, our Diamond Cuban Chain is a dazzling testament to sophistication. Meticulously crafted with precision, each link showcases the brilliance of diamonds, meticulously set in lustrous precious metal. This iconic chain seamlessly blends timeless elegance with a bold, contemporary edge. The classic Cuban link design exudes strength and masculinity, while the diamonds add a touch of luxury that captures attention with every movement. Whether worn solo as a statement piece or layered for a more personalized aesthetic, this Diamond Cuban Chain is an embodiment of enduring craftsmanship, refined taste, and an unwavering commitment to exceptional style.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Diamond Ring",
						"https://i.pinimg.com/originals/f6/aa/4e/f6aa4e7dfb5711cd66dad999be55f4b6.png",
						true,
						random.nextDouble(18, 10000),
						"Glisten with timeless elegance as you adorn your hand with this exquisite diamond ring. Crafted with precision, the dazzling centerpiece features a brilliant-cut diamond, capturing and reflecting light with unparalleled radiance. Set in a delicate band of lustrous white gold, the design exudes sophistication and grace. The minimalist yet opulent setting allows the diamond to take center stage, showcasing its exceptional clarity and brilliance. This ring is more than a piece of jewelry; it's a symbol of enduring love and commitment, a testament to the beauty that lasts a lifetime. Wear it proudly and let its sparkle tell your unique love story.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Silver Hoop Earrings",
						"https://auratenewyork.com/cdn/shop/products/aurate-earrings-hoops-custom-341_1024x1024.png?v=1605204615",
						true,
						random.nextDouble(18, 10000),
						"Elevate your style with these exquisite silver hoop earrings, a timeless accessory that effortlessly blends classic charm with modern elegance. Crafted from high-quality sterling silver, these hoops boast a sleek, polished surface that catches and reflects light, adding a subtle sparkle to your look. The minimalist design allows for versatile pairing, complementing both casual and formal ensembles. The lightweight construction ensures comfort throughout the day, while the secure latch-back closure provides a secure fit. Whether you're dressing up for a special occasion or adding a touch of sophistication to your everyday wear, these silver hoop earrings are a must-have accessory.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Purple Gold Ring",
						"https://www.treatsstudio.co.uk/cdn/shop/files/treats_ring_9.png?v=1688380199&width=1445",
						true,
						random.nextDouble(18, 10000),
						"Behold the allure of this enchanting purple gold ring, a mesmerizing fusion of regal elegance and contemporary flair. Crafted with meticulous precision, the lustrous band showcases a radiant, deep purple gemstone at its heart, encased in a setting of resplendent gold. The rich, royal hues of the purple gem exude sophistication, while the warm embrace of the gold adds a touch of opulence. Delicate engravings on the band enhance its ornate charm, creating a piece that seamlessly blends classic and modern aesthetics. This exquisite ring is more than a piece of jewelry; it's a testament to refined taste and timeless beauty.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Platinum Bracelet",
						"https://cdn11.bigcommerce.com/s-j38el1cgyu/images/stencil/1280x1280/products/7444/24353/BD-3510000_0__28223.1690339445.png?c=1",
						true,
						random.nextDouble(18, 10000),
						"Introducing our exquisite Platinum Bracelet, a stunning embodiment of sophistication and luxury. Meticulously crafted from pure platinum, this bracelet exudes timeless elegance and boasts a radiant luster that captivates admirers. The delicate links intertwine gracefully, forming a seamless and comfortable fit on the wrist. The brilliance of platinum enhances the inherent beauty of the piece, making it a versatile accessory for any occasion. Whether worn solo for a touch of understated glamour or layered with other jewelry, this platinum bracelet is a symbol of refined taste and enduring style. Elevate your collection with this unparalleled statement of opulence.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Butterfly Necklace",
						"https://i.pinimg.com/originals/fb/e3/f5/fbe3f5552f8bca53ce13435d232e56da.png",
						true,
						random.nextDouble(18, 10000),
						"Introducing our exquisite Butterfly Necklace, a mesmerizing fusion of elegance and nature-inspired beauty. Crafted with meticulous precision, this delicate accessory showcases a graceful butterfly motif, its wings adorned with shimmering crystals that catch the light with every movement. The pendant, suspended from a fine chain, creates a whimsical and enchanting effect. Whether worn as a charming everyday piece or to elevate a special occasion, this Butterfly Necklace is a symbol of transformation and grace. With its timeless design and intricate detailing, it adds a touch of ethereal allure to any outfit, making it a must-have for those who appreciate delicate sophistication.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"The Witcher's Wolf Emblem Necklace",
						"https://americanwolves.com/cdn/shop/products/The_Witcher_School_of_the_Wolf_Necklace_-_American_Wolves_600x600.png?v=1582641849",
						true,
						random.nextDouble(18, 10000),
						"The Witcher's Wolf Emblem Necklace is a captivating accessory inspired by the iconic symbol of Geralt of Rivia, the renowned monster hunter. Crafted with meticulous detail, the pendant features the wolf medallion, a symbol of the School of the Wolf—a prestigious order of monster slayers. Made from high-quality materials, the pendant captures the intricate design of the wolf's head, reflecting the Witcher's resilience and strength. This exquisite piece is not merely a stylish adornment but also a homage to the mythical world of The Witcher, making it a must-have for fans and those who appreciate fine craftsmanship and symbolic significance.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Moon Bracelet",
						"https://manonjewelry.com/wp-content/uploads/2013/11/B-MoonCharmBracelet-43207-web-85.png",
						true,
						random.nextDouble(18, 10000),
						"Introducing the Moon Bracelet, an exquisite blend of celestial elegance and contemporary style. Crafted with meticulous precision, this accessory features a delicate silver chain adorned with a crescent moon charm, capturing the mystique of lunar beauty. The moon charm, intricately detailed with subtle engravings, reflects the moon's phases, adding a touch of celestial allure to your ensemble. The adjustable clasp ensures a perfect fit, while the lightweight design guarantees comfort for everyday wear. Whether worn alone for a minimalist statement or layered for a bohemian vibe, the Moon Bracelet is a timeless piece that transcends trends, making it a celestial treasure for any occasion.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Spiky Choker",
						"https://i.pinimg.com/originals/c4/a7/8c/c4a78c23735c432884c3c9850b0e14d9.png",
						true,
						random.nextDouble(18, 10000),
						"Introducing our edgy Spiky Choker – a bold fusion of fashion and rebellion. Crafted with meticulous attention to detail, this statement accessory is designed to captivate attention and unleash your inner rockstar. The choker features a series of sleek, strategically arranged metallic spikes that exude an unmistakable aura of confidence and strength. Whether you're channeling a punk-inspired vibe or seeking to elevate your street-style game, the Spiky Choker is the ultimate choice. Its adjustable closure ensures a comfortable fit, while the gleaming spikes add an element of danger to your look. Make a fearless statement and embrace your individuality with this striking accessory.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Yellow Choker",
						"https://i.pinimg.com/originals/f0/96/67/f0966733612c966977c6bdc455ef907b.png", // https://cdn.reddingo.com/assets/product/overview/DC-ZZ-YE.png
						true,
						random.nextDouble(18, 10000),
						"The radiant Yellow Choker is a striking accessory that effortlessly elevates any outfit with its vibrant charm. Crafted with meticulous attention to detail, this choker features a soft, velvety band that comfortably hugs the neck, creating a bold yet elegant statement. The luscious yellow hue exudes energy and positivity, making it a perfect choice for both casual and formal occasions. Its adjustable closure ensures a snug fit for various neck sizes, while the subtle sheen adds a touch of glamour. Whether paired with a sleek cocktail dress or a casual blouse, this Yellow Choker is a versatile and stylish adornment.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Purple Gold Earrings",
						"https://www.lillianesjewelry.com/wp-content/uploads/101-A2756-1-600x600.png",
						true,
						random.nextDouble(18, 10000),
						"Introducing our exquisite Purple Gold Earrings, a stunning blend of opulence and sophistication. Crafted with precision, these earrings feature lustrous purple gemstones set in a delicately designed gold setting. The rich, regal hues of purple complement the warm glow of the gold, creating a captivating contrast that effortlessly elevates any ensemble. Whether you're attending a gala, a special occasion, or simply want to add a touch of glamour to your everyday look, these earrings are the perfect choice. Radiate elegance and charm with these Purple Gold Earrings, a testament to timeless beauty and refined taste.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Amethyst Necklace",
						"https://www.lillianesjewelry.com/wp-content/uploads/115-B799-1-copy-600x600.png",
						true,
						random.nextDouble(18, 10000),
						"Introducing our exquisite Amethyst Necklace, a harmonious blend of elegance and spiritual allure. This handcrafted masterpiece features a radiant amethyst pendant, gracefully suspended from a delicate sterling silver chain. The mesmerizing violet gemstone, known for its calming energy and spiritual significance, captivates with its deep, translucent hues. The carefully selected amethyst, embraced by a silver bezel, exudes a timeless charm that effortlessly complements any attire. Whether worn as a statement piece or for its metaphysical properties, this Amethyst Necklace adds a touch of sophistication to your ensemble while inviting positive energies into your life. Elevate your style and spirit with this enchanting accessory.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Rolex",
						"https://files.jewelfeed.com/jewelfeed/catalog/items/156af733-6b91-4fb8-ba43-f8818ae00ab9_WkcMv81.png.800x800_q85_keep_alpha.png",
						true,
						random.nextDouble(18, 10000),
						"Rolex, a venerable Swiss luxury watch brand, epitomizes precision, elegance, and craftsmanship since its inception in 1905. Renowned for creating timeless masterpieces, Rolex timepieces seamlessly merge functionality with unparalleled aesthetics. The iconic Oyster Perpetual, born in 1926, introduced the world's first waterproof wristwatch. Subsequent innovations, like the self-winding Perpetual movement and the Datejust's date display, solidified Rolex's horological supremacy. Impeccably designed with 904L steel, precious metals, and cutting-edge technology, each Rolex watch symbolizes a legacy of excellence. Coveted by collectors and synonymous with success, a Rolex transcends time as a symbol of enduring sophistication and prestige.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Richard Mille Antique Watch",
						"https://imageio.forbes.com/blogs-images/nargessbanks/files/2018/03/rm11-03_mcl_fullfront.png?height=106&width=71&fit=bounds",
						true,
						random.nextDouble(18, 10000),
						"The Richard Mille is a pinnacle of horological artistry, an exquisite fusion of precision engineering and avant-garde design. Crafted with unparalleled expertise, these luxury timepieces transcend traditional watchmaking boundaries. Renowned for their lightweight yet durable cases, often made from advanced materials like carbon fiber and titanium, Richard Mille watches redefine elegance with a contemporary edge. The intricately skeletonized dials showcase the intricate movement, a testament to the brand's commitment to technical innovation. Each timepiece is a unique masterpiece, a marriage of form and function that appeals to discerning connoisseurs seeking the epitome of luxury in the world of haute horlogerie.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Gucci Ring",
						"https://itsluxury.com/media/catalog/product/y/b/ybc152045001__1.png?quality=100&fit=bounds&height=&width=",
						true,
						random.nextDouble(18, 10000),
						"The Gucci ring epitomizes opulence and sophistication, seamlessly blending Italian craftsmanship with contemporary design. Crafted from lustrous materials, this iconic piece showcases the brand's commitment to luxury. The ring features the distinctive Gucci logo, meticulously engraved to create a seamless fusion of style and brand identity. Its exquisite detailing and fine finishing make it a statement accessory, reflecting the timeless elegance synonymous with Gucci. Whether worn as a standalone statement or paired with other Gucci pieces, this ring exudes a sense of fashion-forward flair. Elevate your ensemble with the unmistakable allure of the Gucci ring, a symbol of enduring style.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Chanel Nose Ring",
						"https://www.chanel.com/images/t_zoomjewelry2/f_auto/lune-single-earring-white-white-gold-diamond-packshot-default-j12120-9529713360926.jpg",
						true,
						random.nextDouble(18, 10000),
						"Introducing the Chanel Nose Ring, a statement piece that seamlessly blends edgy allure with timeless elegance. Crafted from high-quality materials, this avant-garde accessory captures the essence of Chanel's iconic style. The nose ring features the interlocking C logo, creating a bold and distinctive look that effortlessly elevates any ensemble. Its sleek design reflects the brand's commitment to sophistication, allowing for a seamless transition from casual to formal occasions. Embrace individuality and amplify your fashion statement with this unique piece that embodies the spirit of Chanel – a perfect fusion of contemporary chic and classic sophistication. Redefine your style with the Chanel Nose Ring, where luxury meets rebellion.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Prada Cuban Chain",
						"https://www.prada.com/content/dam/pradanux_products/1/1JC/1JC802/2DTOF0118/1JC802_2DTO_F0118_SLF.png",
						true,
						random.nextDouble(18, 10000),
						"The Prada Cuban Chain is a dazzling accessory that effortlessly merges luxury and bold design. Crafted with precision, this chain showcases Prada's iconic elegance with a contemporary twist. The interlocking links, meticulously detailed and polished to perfection, exude a timeless charm. Its versatility allows it to elevate any outfit, whether draped over a classic black dress or paired with casual attire. The distinct blend of sophistication and urban flair makes the Prada Cuban Chain a statement piece, seamlessly fusing high-end fashion with street-style edge. Embrace a touch of opulence with this accessory, redefining your fashion narrative with Prada's signature allure.",
						250,
						"jewelry"
				));
				itemRepository.save(new Item(
						"Wizard Sphere Necklace pro ultra series-10",
						"https://chairish-prod.freetls.fastly.net/image/product/master/f534c704-582b-48dd-9e66-9d178462f5ff/crystal-iron-and-crystal-orb-pendant-6278",
						true,
						random.nextDouble(18, 10000),
						"The Wizard Sphere Necklace is a captivating piece of mystical craftsmanship. Suspended from a delicate chain, the pendant features a meticulously crafted miniature crystal-clear orb that encapsulates a swirling galaxy of iridescent colors. Infused with enchantments, the sphere emanates a subtle, ethereal glow, casting a mesmerizing aura. The intricately detailed silver or gold-plated casing is adorned with arcane symbols, capturing the essence of ancient wizardry. As the wearer adorns this enchanting necklace, they carry a tangible piece of magic, enhancing their aura with a touch of otherworldly charm. A unique blend of elegance and mysticism, it's a timeless accessory for those who seek the extraordinary.",
						250,
						"jewelry"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Monster Energy Drink",
						"https://cleanfoodsmealprep.com/wp-content/uploads/2021/01/Adobe_Post_20210126_2246430.4344855218195506.png",
						true,
						random.nextDouble(18, 40),
						"Introducing Monster Energy, a powerhouse of refreshment and vitality in a can! Unleash the beast within with this electrifying concoction that fuses exhilarating flavors and potent energy. Packed with a unique blend of caffeine, B-vitamins, and taurine, this vibrant elixir delivers an instant boost to fuel your adventurous spirit. Feel the surge of invigoration as you crack open the iconic black and neon green can, setting the stage for an epic energy experience. Whether you're conquering the day or embracing the night, Monster Energy is your relentless companion, ready to elevate your energy levels and unleash the monster within",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Cake",
						"https://static.vecteezy.com/system/resources/thumbnails/027/098/826/small/chocolate-cake-with-berries-isolated-png.png",
						true,
						random.nextDouble(18, 40),
						"Indulge in the exquisite delight of our signature cake, a symphony of flavors and textures that captivates the senses. Layers of moist, velvety chocolate sponge embrace luscious raspberry compote, creating a harmonious dance of sweet and tangy notes. A generous blanket of smooth, decadent chocolate ganache envelops the masterpiece, enhancing the richness and ensuring each bite is an opulent experience. Topped with artfully crafted chocolate curls and fresh raspberries, the cake is a visual masterpiece as well. Perfect for celebrations or moments of self-pampering, this divine creation promises to elevate your taste buds to new heights of culinary bliss.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Protein Bar - Chocolate",
						"https://www.pureprotein.com/cdn/shop/files/ppr-126517-1-chocolate-deluxe-50g_1_195a16d0-7628-42f8-9de6-f3580979eecf.png?v=1685123337",
						true,
						random.nextDouble(18, 40),
						"Indulge in a guilt-free treat with our delectable chocolate-flavored protein bar. Crafted to satisfy your sweet cravings while fueling your body, this bar seamlessly combines rich cocoa goodness with a high-quality protein blend. Each bite delivers a perfect balance of luscious chocolate flavor and a powerful punch of protein, making it an ideal on-the-go snack or post-workout replenishment. Packed with essential nutrients, this protein bar promotes muscle recovery and supports your active lifestyle. Whether you're seeking a delicious snack or a quick protein boost, our chocolate-flavored protein bar is the scrumptious solution to keep you energized and satisfied.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Protein Bar - Vanilla Caramel",
						"https://sportsfood.no/cdn/shop/products/PowerBar_PP30_VanilCaramCrisp_Foil_sRGB_1_108a5d0c-e79a-4734-8e1a-d95970c6d1fd_1800x1800.png?v=1698910622",
						true,
						random.nextDouble(18, 40),
						"Indulge your taste buds with our Vanilla Caramel Flavored Protein Bar, a delightful fusion of creamy vanilla and rich caramel. Crafted to satisfy your cravings while supporting your fitness goals, this protein-packed treat is a perfect blend of decadence and nutrition. Each bar delivers a substantial protein boost to fuel your body, making it an ideal post-workout snack or a convenient on-the-go pick-me-up. Enjoy the luscious sweetness of vanilla paired with the irresistible richness of caramel, all wrapped up in a convenient, portable package. Elevate your snacking experience with the wholesome goodness of our Vanilla Caramel Flavored Protein Bar.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Beef Jerky",
						"https://www.jacklinks.com/shop/media/catalog/product/1/0/10000017977_3.25oz_jl_bf_swht_jerk_hero.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our premium Beef Jerky Pack, a savory delight for meat enthusiasts. Crafted from the finest cuts of lean beef, our jerky undergoes a meticulous marination process, infusing it with a symphony of bold spices and smoky flavors. Slow-dried to perfection, each strip offers a tender, chewy texture, ensuring a satisfying snacking experience. Packed with high-quality protein, this portable snack is perfect for on-the-go energy or a quick, delicious fix. Gluten-free and without added preservatives, our Beef Jerky Pack promises an authentic taste adventure. Unleash your carnivorous cravings with this protein-packed, flavor-rich snack that's ideal for any adventure or daily indulgence.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Potato Chips - Mexican Fiesta",
						"https://www.kims.no/wp-content/uploads/sites/16/2021/11/Mexican-fiesta.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our Mexican Fiesta Flavored Potato Chips, an explosion of zesty and vibrant taste in every crunch! Immerse yourself in the lively spirit of a fiesta with the bold fusion of chili, lime, and a hint of smoky jalapeño, creating a fiesta of flavors on your palate. Crafted with authentic Mexican spices, these chips capture the essence of street food celebrations. The rich blend of spices is reminiscent of the colorful and lively atmosphere of Mexican fiestas. Whether you're hosting a party or craving a flavorful snack, our Mexican Fiesta Potato Chips will transport you to the heart of a festive celebration. ¡Viva la Fiesta!",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Potato Chips - Salt % Vinegar",
						"https://image.similarpng.com/very-thumbnail/2021/11/Lay's-Salt-&-Vinegar-Flavored-Potato-Chips-on-transparent-background-PNG.png",
						true,
						random.nextDouble(18, 40),
						"\n" +
								"Introducing our Salt & Vinegar Potato Chips, a tantalizing fusion of bold flavors that dance on your taste buds. Each crisp, golden chip is generously coated with the perfect blend of zesty vinegar and savory sea salt, creating an irresistible symphony of tangy goodness. Savor the crunch as the robust vinegar notes intertwine with the classic saltiness, delivering a mouthwatering experience that's both savory and satisfying. Whether you're seeking a snack to elevate your movie nights or craving a burst of flavor during your afternoon break, our Salt & Vinegar Potato Chips are the ideal companion for those who appreciate a deliciously bold snack.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Candy Mix - 500G",
						"https://image.pngaaa.com/573/3540573-middle.png",
						true,
						random.nextDouble(18, 40),
						"\n" +
								"Indulge your sweet tooth with our delightful Mixed Candy Pack, a carnival of flavors in every bite. This vibrant assortment includes an array of chewy, fruity, and tangy treats that promise to tantalize your taste buds. From juicy gummies bursting with fruitiness to rich chocolates oozing with decadence, this pack is a symphony of confectionery goodness. Unwrap the joy of surprises as each piece offers a unique combination of textures and tastes. Perfect for sharing at parties, gifting, or satisfying your sweet cravings, our Mixed Candy Pack is a colorful celebration of sugary bliss that promises to brighten any moment.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Whey Protein - Strawberry",
						"https://medievilnutrition.com/cdn/shop/products/wdp_strawberry_delight.png?v=1702294736&width=1000",
						true,
						5999,
						"Introducing our luscious Strawberry Flavored Whey Protein, a delicious blend designed to elevate your fitness journey. Packed with high-quality whey protein isolate, each serving delivers a potent dose of essential amino acids, promoting muscle recovery and growth. The sweet and refreshing taste of sun-ripened strawberries adds a delightful twist to your post-workout routine, making nutrition a pleasure. Whether you're an avid fitness enthusiast or just starting, our protein pack is a tasty and convenient way to fuel your body. With low fat and sugar content, this Strawberry Flavored Whey Protein is not only a treat for your taste buds but also a smart choice for your overall well-being.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Oreo Cookies - 200G",
						"https://www.checkers.co.za/medias/10739395EA-checkers515Wx515H?context=bWFzdGVyfGltYWdlc3w5MDE2OHxpbWFnZS9wbmd8aW1hZ2VzL2hhZi9oMzIvMTA1NDQxMzc0MzcyMTQucG5nfGViMDNiNjRkOWM1OWU2NGI1Y2JjYjgzMDU3Njc0YzY1ZjQ2ZmY0YmM3ZTAzYTUyOGY3ZjJhNDM4ZDA1NGRlZmU",
						true,
						random.nextDouble(18, 40),
						"\n" +
								"Indulge in the irresistible delight of Oreo cookies, a classic treat that transcends generations. This pack unveils a symphony of flavors and textures, featuring two crisp chocolate wafers hugging a luscious, creamy center. Immerse yourself in the perfect balance of sweetness, as the rich cocoa flavor harmonizes with the velvety vanilla filling. Each bite is a journey, a moment of bliss where crunch meets smoothness. Whether you twist, dunk, or savor them whole, Oreo cookies promise an iconic experience. Share the joy at gatherings, or relish them in solitary bliss—these timeless delights are more than just cookies; they're a celebration of simple pleasures.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Biscuits - 400G",
						"https://e7.pngegg.com/pngimages/774/627/png-clipart-custard-cream-shortbread-arnott-s-shapes-arnott-s-biscuits-biscuit-cream-baked-goods.png",
						true,
						random.nextDouble(18, 40),
						"Indulge in the perfect blend of crispiness and sweetness with our delectable pack of biscuits. Each bite delivers a symphony of flavors, combining a buttery richness with a hint of vanilla, creating an irresistible treat for your taste buds. Baked to perfection, these biscuits boast a satisfying crunch that pairs seamlessly with your favorite hot beverage or stands alone as a delightful snack. Packed with quality ingredients, our biscuits are crafted to offer a comforting and memorable experience. Whether you're sharing them with friends or savoring a quiet moment, our biscuits promise to elevate every break into a moment of pure delight.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"GFuel Starter Pack - 12 Flavours",
						"https://cdn.shopify.com/s/files/1/0223/3113/files/vbk1.png?v=1702893470",
						true,
						random.nextDouble(18, 40),
						"Introducing the ultimate gaming companion: the GFuel Variety Pack with 12 irresistible flavors. Elevate your energy levels and focus with this diverse collection of performance-boosting fuel. Unleash your taste buds with options like Tropical Rain, Blue Ice, Sour Cherry, and more. Each compact sachet is a powerhouse, packed with essential vitamins, antioxidants, and nootropics, ensuring you stay sharp during intense gaming sessions. Whether you crave fruity exhilaration, classic coolness, or bold tanginess, this variety pack caters to every palate. Forget monotony; switch flavors daily for an exciting gaming experience. Revolutionize your energy and taste with GFuel's dynamic range.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Taco Spice",
						"https://www.santamariaworld.com/optimized/product-large/globalassets/uk/products/50239.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our Taco Spice Pack, a culinary journey in every bite! Elevate your taco game with a perfect blend of spices that will tantalize your taste buds and transport you to the vibrant streets of Mexico. This carefully curated pack boasts a harmonious mix of chili powder, cumin, garlic, onion, paprika, and more, ensuring a symphony of flavors in every bite. Versatile and easy to use, simply sprinkle our Taco Spice Pack on ground beef, chicken, or vegetables for an authentic and delicious taco experience. Unleash the fiesta on your palate and savor the bold, zesty notes that make taco night unforgettable!",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"FlapJack",
						"https://maxsportnutrition.com/upload/images/category/flapjack.png",
						true,
						random.nextDouble(18, 40),
						"A flapjack is a delectable treat, marrying simplicity with irresistible sweetness. This dense, chewy square delight is a synergy of rolled oats, golden syrup, butter, and brown sugar. Baked to golden perfection, it emanates a warm, buttery aroma that captivates the senses. With a slightly crunchy exterior giving way to a soft, oaty interior, each bite is a harmonious blend of textures. Often enhanced with variations like dried fruits or nuts, the flapjack is a versatile indulgence, perfect for breakfast or a delightful snack. Its nostalgic charm and comforting taste make it a timeless classic, inviting moments of pure, unadulterated joy.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Organic All-Natural Energy Bar",
						"https://cdn.vilgain.com/image/product/facebook-preview/19ab5151-0498-4d08-b089-cec24e164dc2?v=1675771413",
						true,
						random.nextDouble(18, 40),
						"Introducing our Organic All-Natural Energy Bar, a wholesome blend of nature's finest ingredients to fuel your day. Crafted with care, this nutritious bar combines organic nuts, seeds, and dried fruits, free from artificial additives or preservatives. Packed with essential nutrients, it's a tasty source of sustained energy for your active lifestyle. Every bite delivers a harmonious mix of flavors and textures, offering a satisfying crunch and chewiness. Whether you're on the go, hitting the gym, or seeking a healthy snack, our energy bar is your go-to choice. Elevate your nourishment with this guilt-free, delicious treat that Mother Nature would approve.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Milk Chocolate",
						"https://w7.pngwing.com/pngs/415/821/png-transparent-cadbury-dairy-milk-chocolate-cake-chocolate-bar-cadbury-dairy-milk-cocoa-food-cocoa-bean-superfood.png",
						true,
						random.nextDouble(18, 40),
						"Indulge in the velvety allure of our exquisite milk chocolate, a delectable symphony of rich, creamy flavor that captivates the senses. Crafted from the finest cocoa beans, this chocolate embodies the perfect balance of sweetness and smoothness, ensuring a luxurious melt-in-your-mouth experience. Each velvety square delivers a harmonious blend of cocoa and milk, creating a luscious treat that satisfies the most discerning palates. Whether enjoyed on its own or as a delightful addition to desserts, our milk chocolate promises a moment of pure bliss with every bite. Elevate your taste experience and succumb to the irresistible allure of this heavenly confection.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"White Chocolate",
						"https://i.pinimg.com/originals/08/fb/e5/08fbe57c7535c93165a6a764adeec47c.png",
						true,
						random.nextDouble(18, 40),
						"White chocolate, a velvety indulgence, offers a luscious departure from traditional cocoa-based counterparts. Crafted from cocoa butter, sugar, and milk solids, this ivory confection entices with a rich, creamy texture and sweet, milky flavor. Delicate notes of vanilla dance on the palate, elevating the sweetness to a sublime symphony. Its smooth, ivory hue mirrors its purity, while the absence of cocoa solids distinguishes it from its darker counterparts. A versatile treat, white chocolate adorns desserts with elegance, gracing everything from decadent truffles to dreamy ganaches. Savor the luxurious embrace of this ivory delight, a blissful departure into sweetness.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Midnight Tea",
						"https://www.yogitea.com/site/assets/files/23363/yogi-tea-for-the-senses-good-night-gb-scan.300x0.png",
						true,
						random.nextDouble(18, 40),
						"As the clock strikes midnight, indulge in the enchantment of a Midnight Tea, a celestial blend that transcends time. The quietude of the night is embraced by the aromatic dance of exotic teas, releasing fragrant whispers of jasmine, lavender, and chamomile. Sip into serenity as the velvety infusion caresses your senses, each drop echoing the mysteries of the moonlit hours. A symphony of delicate flavors unfolds—subtle notes of bergamot, vanilla, and a hint of mint. Whether shared in solitude or with kindred spirits, this nocturnal elixir invites reflection and repose, a celestial ritual that transforms midnight into a moment of tranquility.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Instant Coffee Powder - 300G",
						"https://www.nescafe.com/us/sites/g/files/jgfbjl306/files/gdn_product/field_product_images/nescafe-b150474f7ed01776fa185928e86ef29f2692d9f8.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our premium instant coffee powder pack, a delectable blend crafted for the discerning coffee enthusiast. Each convenient sachet contains a harmonious medley of high-quality Arabica and Robusta beans, expertly roasted to perfection. With a rich and robust flavor profile, this instant coffee promises a bold, aromatic experience with every sip. The innovative packaging ensures freshness, preserving the coffee's distinct notes and ensuring a consistently delightful brew. Whether you're at home, in the office, or on the go, savor the convenience without compromising on taste. Elevate your coffee ritual with our instant coffee powder – a symphony of flavor in every packet.",
						250,
						"consumable"
				));
				itemRepository.save(new Item(
						"Liquorice",
						"https://fazerpro.fazer.com/globalassets/remix_salmiakki_230g_404191_web.png",
						true,
						random.nextDouble(18, 40),
						"Licorice, derived from the root of the Glycyrrhiza glabra plant, is a unique and indulgent confection with a rich cultural history. Its distinctive flavor, both sweet and savory, captivates taste buds worldwide. The glossy, black strands of licorice are crafted into various forms, from twists to bites and even as a key ingredient in gourmet candies. Renowned for its natural sweetness, licorice is often used in traditional medicine for its potential health benefits. Beyond its medicinal uses, licorice has become a beloved treat, appreciated for its bold taste and versatility. Whether enjoyed as a nostalgic snack or a culinary accent, licorice offers a timeless and enchanting experience.",
						250,
						"consumable"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Ipad",
						"https://purepng.com/public/uploads/large/purepng.com-ipadelectronicstablet-ipad-941524671278vjvlk.png",
						true,
						random.nextDouble(200, 5000),
						"The iPad, a revolutionary tablet created by Apple, seamlessly blends cutting-edge technology with sleek design. Boasting a stunning Retina display, it delivers vivid colors and sharp details for an immersive visual experience. Its powerful A-series chip ensures swift performance, whether you're multitasking, gaming, or creating content. The intuitive touch interface allows effortless navigation, while the App Store provides access to a vast array of apps tailored for productivity, creativity, and entertainment. With a slim profile and lightweight build, the iPad is effortlessly portable, making it the ideal companion for work or play, bringing innovation and versatility to your fingertips.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Macbook Air 2024",
						"https://support.apple.com/library/APPLE/APPLECARE_ALLGEOS/SP825/macbookair.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing the MacBook Air 2024, a pinnacle of cutting-edge technology and sleek design. This ultraportable laptop embodies innovation with its stunning 13.3-inch Retina display, boasting vibrant colors and crisp details. Powered by the latest M2 chip, it delivers unrivaled speed and efficiency. The feather-light chassis, now even thinner, houses a redesigned keyboard for enhanced typing comfort. With 16GB of unified memory and a spacious 512GB SSD, the MacBook Air ensures seamless multitasking and ample storage. Equipped with Thunderbolt 4 ports, it enables lightning-fast data transfer. Elevate your computing experience with the MacBook Air 2024 – where power meets elegance.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Lenovo Legion 16 pro",
						"https://ongpng.com/wp-content/uploads/2023/04/3.Lenovo-Legion-Y540-1026x806-1.png",
						true,
						random.nextDouble(200, 5000),
						"The Lenovo Legion 16 Pro is a gaming powerhouse designed for uncompromising performance. With a massive 16-inch display featuring a high refresh rate, every frame is delivered with stunning clarity and smoothness, immersing gamers in a visually captivating experience. Powered by cutting-edge processors and top-tier graphics, this laptop ensures seamless gameplay, effortlessly handling resource-intensive titles. Its sleek, modern design combines style with functionality, featuring customizable RGB lighting for a personalized touch. The Legion 16 Pro also boasts advanced cooling technology to keep temperatures in check during intense gaming sessions, allowing enthusiasts to push the limits of performance without compromising on stability.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"The Beast - Stationary Gaming Computer",
						"https://upload.wikimedia.org/wikipedia/commons/f/f5/Avalanche_Hardline_Liquid_Cooled_Gaming_PC.png",
						true,
						random.nextDouble(200, 5000),
						"\n" +
								"Introducing \"The Beast,\" an unparalleled stationary gaming PC that redefines performance boundaries. Powered by a cutting-edge octa-core processor with overclocking capabilities, it roars to life with clock speeds that shatter limits. Graphics prowess is delivered by a top-tier GPU, ensuring every frame is a visual masterpiece. A colossal RAM capacity ensures seamless multitasking, while a lightning-fast SSD guarantees rapid game loading. The Beast's robust cooling system maintains optimal temperatures during the most intense gaming sessions. Immerse yourself in the ultimate gaming experience with customizable RGB lighting and a sleek, futuristic design. Unleash unparalleled power with \"The Beast.\"",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"ThinkPad 2022",
						"https://p2-ofp.static.pub/fes/cms/2022/03/21/3ved6sx5xwp6yhl8lbpo42lgxtblqh290202.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing the ThinkPad 2022, a cutting-edge laptop that seamlessly blends power, portability, and innovation. This sleek device is engineered for productivity, featuring the latest Intel Core processor for lightning-fast performance. The 14-inch display showcases vibrant visuals with precision and clarity, making every task a visual delight. With an ultra-slim design, the ThinkPad 2022 is a portable powerhouse, ideal for professionals on the go. Equipped with advanced security features, including a fingerprint reader and robust encryption, your data remains safeguarded. The backlit keyboard ensures comfortable typing in any environment. Elevate your work experience with the ThinkPad 2022 – where performance meets sophistication.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Galaxy Tablet S9",
						"https://i0.wp.com/mtcfactoryoutlet.com/wp-content/uploads/2021/08/tab-a7-lite.png?fit=3000%2C2000&ssl=1",
						true,
						random.nextDouble(200, 5000),
						"The Samsung Galaxy Tablet S9 combines sleek design with powerful performance. Boasting a vibrant 10.5-inch Super AMOLED display, it offers crisp visuals for both work and entertainment. Equipped with the latest Exynos processor and ample RAM, multitasking is seamless. The S Pen stylus enhances productivity, allowing precise note-taking and creative expression. Its robust battery ensures long-lasting usage, while the quad-speaker system delivers immersive audio. The tablet also features a high-resolution camera for capturing moments on the go. With a slim profile and premium build, the Galaxy Tablet S9 is a versatile companion for users seeking a blend of style and functionality.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"LG 65\" Oled TV",
						"https://www.vhv.rs/dpng/f/11-119933_lg-oled-tv-png-transparent-png.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing the LG 65-inch OLED TV, a pinnacle of visual excellence. Immerse yourself in a breathtaking cinematic experience with its stunning 4K resolution and OLED technology, delivering vibrant colors and perfect blacks. The expansive 65-inch display brings your favorite movies, shows, and games to life, while Dolby Vision and Atmos support elevate audio-visual immersion. The sleek design enhances any living space, featuring a razor-thin profile and minimalist stand. Powered by LG's advanced AI ThinQ, enjoy voice control and smart features, seamlessly integrating with your smart home ecosystem. Elevate your home entertainment with the LG 65-inch OLED TV, where innovation meets unparalleled quality.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Galaxy Phone 23",
						"https://static.vecteezy.com/system/resources/previews/022/722/945/original/samsung-galaxy-s23-ultra-transparent-image-free-png.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing the Samsung Galaxy Phone 23, a marvel of cutting-edge technology and sleek design. Boasting a stunning 6.5-inch Dynamic AMOLED display with an unprecedented 120Hz refresh rate, it delivers immersive visuals and smooth interactions. The phone is powered by the latest Snapdragon processor, ensuring seamless multitasking and efficient performance. Capture life's moments in extraordinary detail with the advanced triple-camera system, featuring a 108MP main sensor. The 5000mAh battery provides all-day endurance, while fast charging and wireless capabilities keep you connected effortlessly. With 5G connectivity, a fingerprint scanner, and the intuitive One UI, the Galaxy Phone 23 redefines the smartphone experience.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Iphone 15 pro max ultra omega",
						"https://storage.googleapis.com/alpine-inkwell-325917.appspot.com/devices/iphone-14-header.png",
						true,
						5999,
						"Introducing the iPhone 15 Pro, a cutting-edge marvel of technology and design. This flagship device seamlessly combines power and sophistication, featuring a stunning 6.7-inch Super Retina XDR display for vibrant visuals. The A16 Bionic chip ensures lightning-fast performance, effortlessly handling demanding tasks and graphic-intensive applications. The triple-camera system, enhanced by AI, captures breathtaking photos and 8K videos, while Night mode delivers impeccable results in low-light conditions. The sleek and durable design, crafted from aerospace-grade aluminum, houses advanced Face ID technology for secure and convenient authentication. With 5G capabilities and an extended battery life, the iPhone 15 Pro redefines mobile excellence.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Massage Pistol",
						"https://static.vecteezy.com/system/resources/previews/010/864/665/original/massage-gun-3d-illustration-free-png.png",
						true,
						random.nextDouble(200, 5000),
						"\n" +
								"Introducing the pinnacle of relaxation technology, our massage pistol is a cutting-edge device designed to provide unparalleled muscle relief. Ergonomically crafted for optimal comfort, this handheld marvel delivers powerful percussive therapy to target sore muscles and alleviate tension. With adjustable speed settings, it caters to individual preferences, ensuring a personalized and soothing experience. The sleek and portable design allows for on-the-go relief, making it an ideal companion for fitness enthusiasts and those seeking post-workout recovery. Equipped with various attachment heads, it offers versatility for targeting specific muscle groups. Unwind and revitalize with our massage pistol, your gateway to relaxation and well-being.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Tesla Optimus - Artificial Intelligence Robot Maid/Butler",
						"https://images.barrons.com/im-477124",
						true,
						random.nextDouble(200, 5000),
						"Introducing the Tesla Optimus AI Robot Maid/Butler, a groundbreaking fusion of cutting-edge technology and household assistance. This sleek, humanoid companion is designed to seamlessly integrate into your daily life, offering unparalleled efficiency and convenience. Powered by advanced artificial intelligence, the Optimus understands and anticipates your needs, effortlessly managing household chores with precision. Equipped with autonomous navigation, it gracefully moves around your home, ensuring a spotless environment. Its interactive touchscreen interface and voice command capabilities make communication intuitive. From cleaning and organizing to providing information and entertainment, the Tesla Optimus AI Robot Maid/Butler redefines domestic assistance, combining innovation with elegance for a truly futuristic home experience.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"1440p 240hz Gaming Monitor",
						"https://ongpng.com/wp-content/uploads/2023/03/31.SAMSUNG-_Odyssey_gaiming_monitor_1573x1632.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing the cutting-edge 1440p 240Hz Gaming Monitor, the epitome of immersive gaming experiences. This sleek monitor boasts a stunning 1440p resolution, delivering crystal-clear visuals with sharp details that enhance every gaming moment. The remarkable 240Hz refresh rate ensures ultra-smooth transitions, reducing motion blur and providing a competitive edge in fast-paced games. Immerse yourself in lifelike colors and deep contrasts, thanks to the advanced display technology. With adaptive sync technology, screen tearing is a thing of the past. Elevate your gaming setup with this monitor's sleek design and unparalleled performance, where every frame is a visual masterpiece in the world of high-performance gaming.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"4k Oled Ultrawide 144hz Monitor",
						"https://storage.aoc.com/assets/8533/AOC_CU34G2_PV_-FTR-large.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing the pinnacle of visual excellence – the 4K OLED Ultrawide 144Hz Monitor. Immerse yourself in a breathtaking display that boasts a stunning 3840x2160 resolution, delivering unparalleled clarity and lifelike imagery. The OLED technology ensures each pixel radiates true-to-life colors with deep blacks, creating an infinite contrast ratio. Elevate your gaming experience with a buttery-smooth 144Hz refresh rate, providing fluid motion and responsiveness. The Ultrawide aspect ratio widens your perspective, offering an expansive view for both work and play. Crafted with precision, this monitor combines cutting-edge technology, sleek design, and an immersive visual feast, setting a new standard for premium displays.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Shure sm7b Microphone",
						"https://products.shureweb.eu/shure_product_db/product_main_images/files/7e1/bf6/ed-/header_transparent/721ed7ee412b45897688a7b5acdefa44.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing the pinnacle of visual excellence – the 4K OLED Ultrawide 144Hz Monitor. Immerse yourself in a breathtaking display that boasts a stunning 3840x2160 resolution, delivering unparalleled clarity and lifelike imagery. The OLED technology ensures each pixel radiates true-to-life colors with deep blacks, creating an infinite contrast ratio. Elevate your gaming experience with a buttery-smooth 144Hz refresh rate, providing fluid motion and responsiveness. The Ultrawide aspect ratio widens your perspective, offering an expansive view for both work and play. Crafted with precision, this monitor combines cutting-edge technology, sleek design, and an immersive visual feast, setting a new standard for premium displays.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"GoXLR Audio Mixing Board",
						"https://mediadl.musictribe.com/media/PLM/data/images/products/P0CQK/2000Wx2000H/Image_TH_P0CQK_GoXLR_Left_XL.png",
						true,
						random.nextDouble(200, 5000),
						"The GoXLR Audio Mixing Board is a revolutionary tool for content creators, streamers, and musicians seeking unparalleled control over their audio setup. With its intuitive design, the GoXLR simplifies the complex process of audio mixing. It features a customizable motorized fader, allowing users to adjust volume levels effortlessly. The vibrant, user-friendly interface provides access to various audio sources, from microphone inputs to music and game sounds. Offering real-time monitoring, EQ settings, and programmable buttons, the GoXLR ensures a professional and dynamic audio experience. Its compact size belies its powerful capabilities, making it an essential companion for anyone looking to elevate their audio production to new heights.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Sony xm5 Headphones",
						"https://store.sony.co.nz/dw/image/v2/ABBC_PRD/on/demandware.static/-/Sites-sony-master-catalog/default/dw2e089ba5/images/WH1000XM5S/WH1000XM5S.png",
						true,
						random.nextDouble(200, 5000),
						"The Sony XM5 headphones redefine audio immersion with cutting-edge technology and sleek design. Delivering an unparalleled listening experience, these wireless over-ear headphones boast industry-leading noise-canceling capabilities, ensuring an escape into pure sound. The Adaptive Sound Control adapts to your surroundings, optimizing noise cancellation accordingly. Immerse yourself in rich, high-resolution audio with the powerful 40mm drivers that reproduce every detail of your favorite tracks. The touch-sensitive controls offer seamless navigation, while the plush ear cushions provide comfort during extended use. With a long-lasting battery life, the Sony XM5 headphones effortlessly blend style, comfort, and exceptional audio performance.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Apple Airpods Max",
						"https://parspng.com/wp-content/uploads/2023/08/airpodspng.parspng.com-3.png",
						true,
						random.nextDouble(200, 5000),
						"The Apple AirPods Max redefine premium audio with their exquisite design and cutting-edge technology. These over-ear headphones boast high-fidelity sound, thanks to custom-built drivers that deliver deep bass, accurate mids, and crisp highs. The adaptive EQ ensures an immersive listening experience by adjusting the sound to the shape of your ears. Active Noise Cancellation (ANC) and Transparency mode provide a tailored auditory experience, allowing you to immerse yourself in music or stay aware of your surroundings. Crafted with a stainless steel frame, breathable knit mesh canopy, and memory foam ear cushions, the AirPods Max offer both comfort and style for an unparalleled audio journey.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Apple Airpods Pro",
						"https://png.pngtree.com/png-vector/20231104/ourmid/pngtree-apple-airpods-pro-png-image_10477533.png",
						true,
						random.nextDouble(200, 5000),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Samsung Earbuds",
						"https://images.samsung.com/is/image/samsung/assets/nz/support/mobile-devices/how-to-activate-samsung-earbuds/1111.png?$ORIGIN_PNG$",
						true,
						random.nextDouble(200, 5000),
						"Introducing Samsung Earbuds, a pinnacle of wireless audio innovation. These sleek and compact earbuds redefine the auditory experience, delivering crisp, clear sound with deep bass and immersive details. Designed for seamless integration with your Samsung devices, they boast advanced Bluetooth connectivity for a hassle-free pairing process. With touch-sensitive controls, you can effortlessly manage calls, adjust volume, or navigate tracks. The ergonomic design ensures a comfortable fit, while intelligent sensors detect when you're wearing them, pausing playback when removed. Additionally, the long-lasting battery life ensures extended listening enjoyment, making Samsung Earbuds the perfect companion for those who demand exceptional audio quality on the go.",
						250,
						"technology"
				));
				itemRepository.save(new Item(
						"Meta Quest 3",
						"https://www.synergiz.com/wp-content/uploads/2023/10/meta-quest-3.png",
						true,
						random.nextDouble(200, 5000),
						"Introducing Meta Quest 3, a groundbreaking leap into the future of virtual reality. This immersive headset redefines the boundaries of digital experience, boasting unparalleled realism and functionality. Meta Quest 3 combines cutting-edge optics with an expansive field of view, transporting users into vivid, lifelike environments. Its ergonomic design ensures comfort during extended use, while advanced haptic feedback technology enhances tactile sensations. Powered by an ultra-fast processor, it delivers seamless, lag-free interactions. With an evolved tracking system and intuitive gesture controls, Meta Quest 3 offers an unparalleled level of immersion. Step into a new dimension of gaming, education, and social connectivity with the Meta Quest 3 – where the virtual becomes reality.",
						250,
						"technology"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Gardening Gloves",
						"https://i.pinimg.com/originals/90/3d/9d/903d9df97b3adcc1d45a6ca0a16651b2.png",
						true,
						random.nextDouble(18, 40),
						"Gardening gloves are essential companions for green thumbs, offering both protection and functionality. Crafted from durable materials like leather or synthetic fabrics, these gloves shield hands from scratches, thorns, and abrasive elements encountered during gardening tasks. Designed with reinforced fingertips and palms, they ensure a firm grip on tools while maintaining dexterity for delicate tasks like planting or pruning. Breathable materials prevent sweat buildup, enhancing comfort during prolonged use. With various styles to suit different needs, from heavy-duty options for landscaping to lightweight gloves for precision work, these garden essentials provide the perfect balance of comfort and protection for any gardening enthusiast.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Pruning Shears",
						"https://cpimg.tistatic.com/05429902/b/4/Pruning-Shear-Agriculture-Tools-.png",
						true,
						random.nextDouble(18, 40),
						"Pruning shears, essential tools for garden enthusiasts and horticulturists, are precision-cutting instruments designed to trim and shape plants with ease. Crafted with a durable blend of steel or aluminum, these handheld scissors boast razor-sharp blades that effortlessly slice through branches, stems, and twigs. Equipped with ergonomic handles, pruning shears offer a comfortable grip, minimizing hand fatigue during prolonged use. Ideal for precise pruning, these versatile shears promote plant health by removing dead or overgrown foliage. Whether tending to a flourishing garden or maintaining landscape aesthetics, pruning shears are indispensable for fostering the growth and beauty of plants with efficiency and precision.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Watering Can",
						"https://gallery.yopriceville.com/var/resizes/Free-Clipart-Pictures/Spring-PNG/Watering_Can_PNG_Clip_Art_Image.png?m=1517889302",
						true,
						random.nextDouble(18, 40),
						"Introducing our elegant watering can, a perfect blend of form and function for your gardening needs. Crafted from durable, corrosion-resistant materials, this watering can boasts a sleek design that complements any garden or indoor space. Its generous capacity ensures fewer refills, while the long spout facilitates precise watering, reaching even the most delicate plants. The ergonomic handle provides a comfortable grip, making it effortless to carry and pour. Whether you're nurturing blooming flowers or lush greenery, this watering can is a stylish and efficient tool, adding a touch of sophistication to your gardening routine. Make every drop count with our exceptional watering can.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Soil Moisture Meter",
						"https://my.mouser.com/images/marketingid/2018/img/112439723_Sparkfun_Soil%20Moisture%20Sensor%20with%20Screw%20Terminals.png?v=070223.0511",
						true,
						random.nextDouble(18, 40),
						"The Soil Moisture Meter is an essential tool for gardeners and farmers, designed to accurately measure the moisture content of soil. This handheld device features a probe that is inserted into the soil, providing instant readings to help users determine the optimal watering conditions for plants. With a user-friendly interface and a clear digital display, it eliminates the guesswork associated with watering routines. The meter helps prevent overwatering or underwatering, promoting healthier plant growth and conservation of water resources. Compact and durable, it's suitable for both indoor and outdoor use, making it an indispensable companion for anyone passionate about gardening or agriculture.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Plant Pot",
						"https://purepng.com/public/uploads/large/purepng.com-flower-potflower-object-gardening-pot-terracotta-plastic-garden-961524680055ywhu0.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our elegant ceramic plant pot, a harmonious blend of functionality and style. Crafted with meticulous attention to detail, this exquisite pot is the perfect home for your favorite plants, adding a touch of nature to any space. The smooth, glazed surface exudes a modern charm, while the sturdy construction ensures durability. Its versatile design seamlessly complements various interior aesthetics, from contemporary to traditional. The pot's generous size accommodates a variety of plant sizes, making it ideal for both small succulents and larger foliage. Elevate your living space with this sophisticated plant pot, where beauty meets botanical bliss.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Fertilizer",
						"https://www.unikeyterra.com/wp-content/uploads/2020/01/Unikey-AN-33-Ammonium-Nitrate.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our premium fertilizer blend, the GreenGrowth Power Pack! Specially formulated to rejuvenate your garden, this dynamic blend of essential nutrients ensures robust plant growth and vibrant blooms. Packed with nitrogen, phosphorus, and potassium, it caters to the diverse needs of various plants, promoting strong root development, lush foliage, and abundant flowering. The slow-release formula guarantees a steady and prolonged nutrient supply, enhancing soil fertility and resilience. Whether you're a seasoned gardener or a novice, the GreenGrowth Power Pack is your go-to solution for cultivating a thriving and verdant garden. Watch your plants flourish with vitality and vitality with each application!",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Trowel",
						"https://freepngimg.com/thumb/tools/175191-garden-trowel-free-transparent-image-hq.png",
						true,
						random.nextDouble(18, 40),
						"The Garden Trowel is a versatile and indispensable tool for any gardening enthusiast. Crafted with a durable stainless steel blade, this trowel effortlessly cuts through soil, allowing for easy planting and transplanting of flowers, herbs, and vegetables. The ergonomic handle ensures a comfortable grip, reducing strain during extended use. Its compact design makes it perfect for navigating through tight spaces in your garden bed. The polished surface not only enhances its aesthetic appeal but also facilitates easy cleaning after use. With its robust construction and user-friendly features, the Garden Trowel is an essential companion for every gardener, making planting a breeze.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Rake",
						"https://pngimg.com/d/rake_PNG32.png",
						true,
						random.nextDouble(18, 40),
						"The Garden Rake is an indispensable tool for maintaining a pristine outdoor space. Crafted with durable materials, its long handle and sturdy tines make it ideal for efficiently raking leaves, debris, and loose soil. The rust-resistant design ensures longevity, even in varying weather conditions. Its ergonomic handle provides a comfortable grip, minimizing strain during extended use. This versatile rake is not limited to fall cleanup; it excels in leveling and smoothing soil, preparing flower beds, and aiding in overall garden maintenance. With precision and reliability, the Garden Rake becomes an essential companion for any gardening enthusiast, simplifying the beautification process.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Gardening Knee Pads",
						"https://en.hoegert.com/wp-content/uploads/2023/05/HT5K296.png",
						true,
						random.nextDouble(18, 40),
						"Gardening knee pads are indispensable accessories for any avid gardener, providing optimal comfort and protection during prolonged kneeling sessions. Crafted from durable, moisture-resistant materials, these knee pads offer excellent support, reducing strain on joints and preventing soil and moisture from penetrating through. The ergonomic design ensures a snug fit, allowing free movement while tending to plants or performing ground-level tasks. Equipped with adjustable straps, they cater to various sizes and preferences. Whether planting, weeding, or cultivating, these knee pads are a reliable ally, ensuring that gardening remains a pleasurable experience by safeguarding your knees from discomfort and potential injuries.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Composite Bin",
						"https://res.cloudinary.com/hksqkdlah/image/upload/ATK%20Reviews/2022/Compost%20Bins/SIL_Exaco_Eco-2000-Kitchen-Compost-Pail_2000.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our innovative composite bin – a cutting-edge solution for sustainable waste management. Crafted from a blend of eco-friendly materials, this bin seamlessly combines durability with environmental consciousness. Its sleek design seamlessly integrates into any setting, enhancing both functionality and aesthetics. The composite material not only ensures a robust structure but also minimizes environmental impact, promoting a greener lifestyle. Featuring multiple compartments for easy waste segregation, it encourages responsible disposal practices. This versatile bin is ideal for both indoor and outdoor use, offering a modern and conscientious approach to waste disposal. Upgrade your space with our composite bin and embrace a cleaner, greener future.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Sprayer",
						"https://www.holmanindustries.com.au/wp-content/uploads/GC8050-EzySpray-5L-Pump-Free-Garden-Sprayer-3.png",
						true,
						random.nextDouble(100, 200),
						"Introducing our Garden Master Sprayer, a versatile solution for effortless and efficient gardening. This compact and lightweight sprayer is designed to simplify your plant care routine. With a robust 2-gallon capacity, it ensures extended coverage for your garden, eliminating the need for constant refills. The ergonomic handle and adjustable nozzle provide precise control over spray patterns, catering to various plant sizes and types. The translucent tank allows for easy monitoring of liquid levels, preventing unexpected interruptions. Crafted from durable materials, our Garden Master Sprayer guarantees longevity and resilience against harsh outdoor conditions. Elevate your gardening experience with this reliable and user-friendly sprayer.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Plant Markers",
						"https://seed2plant.in/cdn/shop/products/PhotoRoom_20210920_160829.png",
						true,
						random.nextDouble(18, 40),
						"Plant markers are essential tools for every garden enthusiast. These small but indispensable items serve as efficient labels for your plants, aiding in easy identification and organization. Crafted from durable materials like weather-resistant plastic, metal, or wood, these markers withstand the elements while maintaining clarity. Designed with user-friendliness in mind, many come with a writable surface for noting plant names, sowing dates, or care instructions. Whether you're cultivating a vibrant vegetable garden or a colorful flower bed, these plant markers add a touch of organization and ensure that you'll never mix up your herbs or flowers again.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Insect Netting",
						"https://nunababy.eu/pub/media/catalog/product/s/i/sizedsena_insect_net_beauty_1__7ffb.png?type=product&height=400&width=400",
						true,
						random.nextDouble(18, 40),
						"Insect netting, a mesh fabric designed to protect against unwanted pests, is a versatile solution for maintaining a bug-free environment. Crafted from durable materials, this netting acts as an effective barrier, preventing insects from infiltrating spaces without obstructing airflow or natural light. Ideal for windows, doors, or outdoor spaces, insect netting provides a shield against mosquitoes, flies, and other pesky bugs, ensuring a comfortable and hygienic living or recreational area. Easy to install and maintain, it offers a cost-effective and eco-friendly alternative to chemical insect repellents. Enjoy the outdoors or relax indoors without the nuisance of buzzing intruders with the reliable protection of insect netting.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Solar Powered Garden Lights",
						"https://globeledphilippines.com/wp-content/uploads/2018/07/Solar_Garden_Lights.png",
						true,
						random.nextDouble(18, 40),
						"Illuminate your garden with our eco-friendly Solar-Powered Garden Lights. Harnessing the power of the sun during the day, these lights charge their built-in batteries to provide a soft, ambient glow in the evening. Designed with durability in mind, the weather-resistant construction ensures longevity, even in diverse climates. Easy to install, these lights require no wiring, making them a hassle-free addition to your outdoor space. Choose from a variety of styles to complement your garden aesthetics. The automatic on/off feature conserves energy, and the LED bulbs emit a warm, inviting light, creating a charming atmosphere while reducing your carbon footprint. Enjoy enchanting nights with sustainable elegance.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Wheelbarrow",
						"https://pngimg.com/d/wheelbarrow_PNG12.png",
						true,
						random.nextDouble(18, 40),
						"The wheelbarrow is a versatile and indispensable tool for various outdoor tasks. Crafted from sturdy materials like steel or durable plastic, its design features a deep, open container supported by a single wheel and two handles. This ergonomic structure allows for easy maneuverability, enabling users to transport heavy loads of soil, mulch, or other materials with minimal effort. The wheel's pneumatic tire ensures smooth navigation across uneven terrain. Whether used in gardening, construction, or landscaping, the wheelbarrow proves essential for hauling, dumping, and distributing materials efficiently. Its simple yet effective design makes it a reliable companion for a range of outdoor projects.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Rain Barrel",
						"https://pngimg.com/d/wheelbarrow_PNG12.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our EcoHarvest Rain Barrel — the perfect blend of sustainability and functionality. Crafted from durable, recycled materials, this 55-gallon rain barrel elegantly captures and stores rainwater, reducing your environmental footprint. The sleek design seamlessly integrates into any outdoor space, featuring a tight-fitting lid to keep debris out and a convenient spigot for easy access to collected water. Save on water bills by harnessing nature's gift to nurture your garden or hydrate plants. With a built-in overflow system and a mesh screen to filter contaminants, the EcoHarvest Rain Barrel effortlessly transforms rain into a valuable resource for eco-conscious living.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Kneeler",
						"https://richmondrose-store.com/cdn/shop/products/Screenshot2020-07-06at17.30.07_cabca975-6351-4d4d-8de7-0288772afe62.png?v=1658753338",
						true,
						random.nextDouble(18, 40),
						"The garden kneeler is a versatile and ergonomic tool designed to enhance your gardening experience. Crafted with a sturdy yet lightweight frame, it provides a comfortable and supportive surface for kneeling or sitting while tending to your plants. The padded cushion reduces strain on your knees and lower back, making prolonged gardening sessions more enjoyable. Flip it over, and it transforms into a convenient seat, allowing you to take breaks without leaving your garden. Equipped with handles on both sides, it's easily portable and can also serve as a helpful assistive device for getting up and down. A must-have for any gardening enthusiast, this kneeler combines functionality with comfort in the outdoor oasis.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Weeder",
						"https://png.pngtree.com/png-vector/20230426/ourmid/pngtree-reflective-automatic-weeder-png-image_6734400.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our premium garden weeder, designed to make your gardening experience effortless. Crafted with durable stainless steel, this tool ensures longevity and resilience against the toughest soil and weed challenges. The ergonomic handle provides a comfortable grip, reducing hand fatigue during prolonged use. The pointed, serrated blade effortlessly penetrates the soil, allowing for precise weed removal without disturbing surrounding plants. Its compact design makes it ideal for tight spaces and between delicate blooms. Say goodbye to unsightly weeds with this efficient garden weeder, a must-have for any gardening enthusiast seeking a reliable and user-friendly solution for maintaining a pristine garden.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Garden Trellis",
						"https://lancastersonline.com/cdn/shop/products/Trellis_big_web.png?v=1677164785",
						true,
						random.nextDouble(18, 40),
						"A garden trellis is a charming and functional addition to any outdoor space. Crafted from durable materials such as wood, metal, or vinyl, these latticed structures serve as both decorative elements and practical supports for climbing plants. Designed to elevate your garden aesthetics, trellises come in various styles, from classic to modern, enhancing the overall visual appeal of your landscape. As vines gracefully wind around the lattice, the trellis provides vertical interest, transforming your garden into a lush and vibrant haven. With their versatility, garden trellises offer an elegant solution for creating privacy, defining spaces, and cultivating a flourishing green sanctuary.",
						250,
						"gardening"
				));
				itemRepository.save(new Item(
						"Sprinkler",
						"https://static.wixstatic.com/media/541ad8_0c0d7b1c6a5f4317aef128d470b12673~mv2.png/v1/fill/w_480,h_316,al_c,lg_1,q_85,enc_auto/water%20sprinkler.png",
						true,
						random.nextDouble(18, 40),
						"The GardenWave Pro Sprinkler effortlessly transforms mundane watering into a choreographed dance for your garden. With a 360-degree rotating head and adjustable spray patterns, this innovative sprinkler ensures uniform coverage for lawns, flower beds, and vegetable patches. Crafted from durable, rust-resistant materials, the GardenWave Pro stands up to the elements for long-lasting use. The user-friendly design allows easy adjustments to control the water distance and flow intensity. Whether you seek a gentle mist for delicate plants or a powerful stream for thirsty lawns, this sprinkler adapts to your garden's unique needs, making it a reliable ally in cultivating a vibrant, thriving landscape.",
						250,
						"gardening"
				));

				/*          !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       */

				itemRepository.save(new Item(
						"Cloud Sofa",
						"https://i.pinimg.com/originals/53/d8/82/53d882b543326bfa86515e736b6e054b.png",
						true,
						random.nextDouble(4999, 5000),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Dining Table",
						"https://freepngimg.com/download/dining_table/4-2-dining-table-transparent.png",
						true,
						random.nextDouble(200, 500),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Chair",
						"https://pngimg.com/d/chair_PNG6847.png",
						true,
						random.nextDouble(18, 40),
						"The Cloud Sofa transcends conventional comfort, enveloping you in a celestial cocoon of luxury. Crafted with plush, cloud-like cushions, it redefines relaxation with its ethereal design. Sink into the sumptuous depths of its generous seating, surrounded by soft, breathable fabrics that echo the sensation of lounging on clouds. The modular structure allows for versatile configurations, adapting to your space seamlessly. The minimalist aesthetic, coupled with a robust frame, ensures both style and durability. Whether you seek a serene retreat for contemplation or a cozy haven for social gatherings, the Cloud Sofa elevates your living space to heavenly heights of comfort.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Bed",
						"https://pngimg.com/d/bed_PNG17418.png",
						true,
						random.nextDouble(2000, 3000),
						"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Wardrobe",
						"https://i.pinimg.com/originals/08/ba/ca/08bacad019414e3eea1ad2c449f0a1a9.png",
						true,
						random.nextDouble(100, 200),
						"Introducing our elegant and functional wardrobe, a masterpiece of organization and style. Crafted with precision from durable wood, this wardrobe seamlessly blends contemporary aesthetics with practical design. The spacious interior offers a haven for your clothing, featuring multiple shelves, drawers, and hanging rods to accommodate your diverse wardrobe. Its sleek exterior, adorned with subtle detailing and a rich finish, effortlessly elevates any room decor. The smooth sliding doors ensure easy access while saving space, making it an ideal solution for bedrooms, dressing rooms, or walk-in closets. Upgrade your storage experience with this sophisticated wardrobe, where form meets functionality.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Bookshelf",
						"https://areastore.com/cdn/shop/files/57387_300x.png?v=1697039968",
						true,
						random.nextDouble(18, 40),
						"Embrace the beauty of organized chaos with our exquisite Harmony Haven Bookshelf. Crafted from rich mahogany, this bookshelf seamlessly blends form and function. Its six spacious shelves offer a symphony of storage, providing a haven for your beloved books, cherished collectibles, and decorative accents. The elegant design, featuring ornate detailing and a classic finish, adds a touch of timeless sophistication to any room. Versatile and sturdy, the Harmony Haven Bookshelf is not just a piece of furniture but a statement of style, inviting you to curate your literary world in a display of literary elegance and visual appeal.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Desk",
						"https://www.pngall.com/wp-content/uploads/2/Desk.png",
						true,
						random.nextDouble(18, 40),
						"The Harmony Desk seamlessly blends functionality with a modern aesthetic, making it an ideal addition to any workspace. Crafted from high-quality, sustainable oak, its sleek design features clean lines and a spacious tabletop, providing ample room for creativity to flourish. The desk is equipped with integrated storage solutions, including drawers and compartments, ensuring an organized and clutter-free environment. Its sturdy construction guarantees durability, while subtle details like brushed metal handles add a touch of sophistication. Whether used for work or study, the Harmony Desk invites productivity and complements contemporary interiors, embodying a perfect balance of style and utility.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Night Stand",
						"https://www.pngall.com/wp-content/uploads/5/Wooden-Night-Table-PNG-Image.png",
						true,
						random.nextDouble(18, 40),
						"A nightstand is a versatile and essential bedroom companion, offering both functionality and style. This compact piece of furniture typically sits beside the bed, providing a convenient surface for essentials. With drawers or shelves, it accommodates items like books, reading glasses, or a bedside lamp, keeping them within easy reach. Nightstands often feature elegant designs to complement bedroom aesthetics, ranging from modern and minimalist to classic and ornate. Crafted from various materials such as wood, metal, or even glass, they enhance the overall bedroom decor. Beyond their practicality, nightstands contribute to a well-organized and aesthetically pleasing sleep space.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Armchair",
						"https://i.pinimg.com/originals/54/1d/d4/541dd467d515c5b93a024391eb3f0796.png",
						true,
						5999,
						"Introducing the epitome of comfort and style – our exquisite armchair. Crafted with precision, its plush upholstery invites you to sink into a world of relaxation. The sleek design seamlessly blends modern aesthetics with timeless charm, making it a versatile addition to any living space. The gently curved armrests and ergonomic shape provide optimal support, ensuring a delightful lounging experience. The sturdy frame and high-quality materials guarantee durability, while the neutral tones effortlessly complement various décor styles. Whether you're unwinding with a book or hosting guests, this armchair becomes the focal point of comfort and sophistication, elevating your home's ambiance.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Cupboard",
						"https://purepng.com/public/uploads/large/purepng.com-cupboardcupboardpressa-cabinetdoor-and-shelves-1701527921934nsnco.png",
						true,
						random.nextDouble(18, 40),
						"The enchanting cupboard, a versatile storage solution, seamlessly blends functionality with aesthetics. Crafted from rich, durable wood, its smooth finish radiates timeless elegance. This well-designed piece features ample shelving within, offering organized spaces for your treasured belongings. The cupboard's doors, adorned with intricate detailing, exude sophistication and charm. Ideal for any room, it stands as a testament to craftsmanship and practicality. Whether utilized in the kitchen for pantry essentials, the bedroom for clothes, or the living room for decorative pieces, this cupboard is a stylish and efficient addition to your home, effortlessly elevating your interior design.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"TV stand",
						"https://t3.ftcdn.net/jpg/06/16/26/16/360_F_616261662_4b1CL8G1G0orM8Pl9vcX1M1ZREKbqL3a.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our contemporary TV stand, a perfect blend of style and functionality for your entertainment space. Crafted with precision, the stand features a sleek design with clean lines, enhancing the modern aesthetics of any room. Constructed from durable materials, it provides a sturdy foundation for your television, offering ample space for peripherals and media storage. The spacious shelving accommodates gaming consoles, cable boxes, and more, keeping your entertainment setup organized. Cable management is seamlessly integrated, ensuring a tidy appearance. Whether you're binge-watching your favorite shows or hosting a movie night, this TV stand is the ideal addition, combining sophistication and practicality.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Coffee Table",
						"https://floydhome.com/cdn/shop/products/Coffee_Default_Birch-Black.0001.png?v=1613585906",
						true,
						random.nextDouble(18, 40),
						"The Zenith Coffee Table seamlessly blends style and functionality, making it the perfect centerpiece for any living space. Crafted from solid oak with a rich walnut finish, its sleek, contemporary design features clean lines and a spacious surface. The tabletop, adorned with subtle geometric patterns, adds a touch of modern flair while providing ample space for displaying decor or holding your favorite books and magazines. The sturdy construction ensures durability, and the lower shelf offers additional storage or a showcase area. With its timeless aesthetic and practicality, the Zenith Coffee Table effortlessly enhances the ambiance of your home, inviting relaxation and conversation.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Carpet",
						"https://pngimg.com/d/carpet_PNG19.png",
						true,
						random.nextDouble(18, 40),
						"Introducing the epitome of comfort and style – our luxurious carpet transcends conventional flooring, transforming any space into a cozy haven. Crafted with precision, its plush, velvety texture invites a tactile indulgence underfoot, creating an atmosphere of warmth and tranquility. The rich color palette, ranging from soothing neutrals to vibrant hues, effortlessly complements diverse interior aesthetics. Stain-resistant and resilient, this carpet ensures both durability and easy maintenance. Whether enhancing the elegance of a living room or providing a soft landing in a bedroom, our carpet seamlessly blends aesthetics with functionality, adding a touch of opulence to every step taken.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Mirror",
						"https://purepng.com/public/uploads/large/purepng.com-mirrormirrorspeculumlookinlooking-glass-1701527941267fodjo.png",
						true,
						random.nextDouble(18, 40),
						"Introducing our elegant Embrace Reflections Wall Mirror, a captivating blend of form and function. This sophisticated mirror not only adds a touch of glamour to any space but also amplifies the ambient light, creating an illusion of spaciousness. The sleek, frameless design seamlessly integrates into diverse décor styles, from modern to classic. Crafted with precision, the high-quality glass provides crystal-clear reflections, enhancing both natural and artificial light sources. Measuring 36 inches in diameter, the Embrace Reflections Mirror becomes a focal point, elevating the aesthetic appeal of bedrooms, living rooms, or entryways. Redefine your space with timeless allure.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Chest",
						"https://pngimg.com/uploads/treasure_chest/treasure_chest_PNG157.png",
						true,
						random.nextDouble(18, 40),
						"The timeless and versatile chest stands as an embodiment of both elegance and functionality. Crafted with precision, its sturdy wooden frame boasts a rich finish that adds warmth to any room. Featuring a spacious interior, the chest provides ample storage for clothing, linens, or cherished belongings. The carefully designed drawers effortlessly glide open, revealing a perfect blend of form and utility. With its classic design, this chest seamlessly complements various decor styles, from traditional to modern. It not only enhances organizational efficiency but also serves as a tasteful centerpiece, elevating the aesthetics of bedrooms, living rooms, or entryways.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Chest of Drawers",
						"https://pngimg.com/d/dresser_PNG159.png",
						true,
						random.nextDouble(18, 40),
						"Elevate your bedroom organization with our exquisite Chest of Drawers. Crafted from rich, durable hardwood, this sophisticated piece seamlessly blends functionality with style. Five spacious drawers provide ample storage for your clothing, linens, and personal belongings. Each drawer glides effortlessly on smooth metal runners, ensuring easy access to your essentials. The elegant design features subtle detailing, including sleek handles and a polished finish that enhances any decor. This Chest of Drawers not only declutters your space but also adds a touch of timeless charm. Embrace a well-organized and aesthetically pleasing bedroom with this essential furniture piece.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Futon",
						"https://freepngimg.com/download/aquarium/43451-9-futon-free-photo-png.png",
						true,
						random.nextDouble(300, 500),
						"A futon is a versatile and space-saving furniture piece that seamlessly combines the functionality of a sofa and a bed. Its design typically features a sturdy frame that can be easily converted from a comfortable seating arrangement during the day to a cozy bed at night. Futons are known for their adaptability, making them ideal for small living spaces, guest rooms, or home offices. The frame often allows for the folding or unfolding of the mattress, and the cushioning provides a comfortable sitting or sleeping surface. Futons come in various styles, materials, and sizes, catering to both aesthetic preferences and practical needs.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Dresser",
						"https://www.pngall.com/wp-content/uploads/3/Dresser-PNG-Free-Download.png",
						true,
						random.nextDouble(18, 40),
						"The elegant dresser seamlessly combines form and function, offering a sophisticated storage solution for any bedroom or living space. Crafted from high-quality wood, its sleek design features smooth lines and a rich finish, adding a touch of timeless style to your decor. With a generous array of drawers, it provides ample space to organize and store clothing, accessories, or personal items. The sturdy construction ensures durability, while the metal or wooden handles add a subtle touch of refinement. This dresser effortlessly marries practicality with aesthetics, making it a perfect addition to elevate the ambiance of your room with both charm and utility.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Mannequin",
						"https://static.vecteezy.com/system/resources/thumbnails/018/875/006/small/body-anatomy-isolated-on-background-free-png.png",
						true,
						random.nextDouble(18, 40),
						"Introducing the ApexFlex Mannequin, a revolutionary blend of artistry and functionality. Crafted with meticulous attention to detail, this lifelike form transcends traditional expectations, offering an exquisite canvas to showcase your fashion creations. The ApexFlex Mannequin boasts a sleek, matte finish that enhances the visual appeal of any display, capturing the essence of contemporary design. Its poseable joints and realistic proportions lend an air of authenticity, making it an ideal choice for fashion retailers and designers seeking to elevate their presentations. Embrace the future of visual merchandising with the ApexFlex Mannequin – where style and innovation unite in a captivating display.",
						250,
						"furniture"
				));
				itemRepository.save(new Item(
						"Ottoman",
						"https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-ottoman-and-pouf-3d-render-png-image_10165345.png",
						true,
						random.nextDouble(18, 40),
						"The Ottoman is a versatile and stylish addition to any living space, seamlessly blending comfort and functionality. Crafted with meticulous attention to detail, its plush upholstery invites relaxation, serving as a comfortable footrest or an extra seat for guests. The carefully chosen fabric or leather complements various design aesthetics, from classic to contemporary. Its compact form makes it an ideal space-saving solution, while the sturdy base ensures durability. Some ottomans even feature storage compartments, providing a discreet yet convenient place to stow away blankets or magazines. Elevate your home decor with this chic and practical piece that effortlessly enhances lounging spaces.",
						250,
						"furniture"
				));
			} catch(Exception e) {
				e.printStackTrace();
			}
		};
	}
}
