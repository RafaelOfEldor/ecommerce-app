# resource "aws_route53_record" "acm_validation_www" {
#   zone_id = var.route53_zone_id
#   name    = "_335c57f912029abf1d9f3dc50266dd14.www.mock-ecommerce.com."   # <-- Paste from ACM
#   type    = "CNAME"
#   ttl     = 300
#   records = ["_79ac56eb4c79e5d0663456a3dd94f5ad.sdgjtdhdhz.acm-validations.aws."]  # <-- Paste from ACM
# }
#
# resource "aws_route53_record" "acm_validation_root" {
#   zone_id = var.route53_zone_id
#   name    = "_ae277d44dc76878be5931ef08d7f4d03.mock-ecommerce.com."   # <-- Second ACM CNAME
#   type    = "CNAME"
#   ttl     = 300
#   records = ["_f8002a2eb2427a26e37ec6f92dc54300.sdgjtdhdhz.acm-validations.aws."]
# }
