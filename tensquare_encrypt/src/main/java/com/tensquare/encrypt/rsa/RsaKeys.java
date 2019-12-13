package com.tensquare.encrypt.rsa;

/**
 * rsa加解密用的公钥和私钥
 * @author Administrator
 *
 */
public class RsaKeys {

	//生成秘钥对的方法可以参考这篇帖子
	//https://www.cnblogs.com/yucy/p/8962823.html

//	//服务器公钥
//	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6Dw9nwjBmDD/Ca1QnRGy"
//											 + "GjtLbF4CX2EGGS7iqwPToV2UUtTDDemq69P8E+WJ4n5W7Iln3pgK+32y19B4oT5q"
//											 + "iUwXbbEaAXPPZFmT5svPH6XxiQgsiaeZtwQjY61qDga6UH2mYGp0GbrP3i9TjPNt"
//											 + "IeSwUSaH2YZfwNgFWqj+y/0jjl8DUsN2tIFVSNpNTZNQ/VX4Dln0Z5DBPK1mSskd"
//											 + "N6uPUj9Ga/IKnwUIv+wL1VWjLNlUjcEHsUE+YE2FN03VnWDJ/VHs7UdHha4d/nUH"
//											 + "rZrJsKkauqnwJsYbijQU+a0HubwXB7BYMlKovikwNpdMS3+lBzjS5KIu6mRv1GoE"
//											 + "vQIDAQAB";
//
//	//服务器私钥(经过pkcs8格式处理)
//	private static final String serverPrvKeyPkcs8 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDoPD2fCMGYMP8J"
//				 								 + "rVCdEbIaO0tsXgJfYQYZLuKrA9OhXZRS1MMN6arr0/wT5YniflbsiWfemAr7fbLX"
//				 								 + "0HihPmqJTBdtsRoBc89kWZPmy88fpfGJCCyJp5m3BCNjrWoOBrpQfaZganQZus/e"
//				 								 + "L1OM820h5LBRJofZhl/A2AVaqP7L/SOOXwNSw3a0gVVI2k1Nk1D9VfgOWfRnkME8"
//				 								 + "rWZKyR03q49SP0Zr8gqfBQi/7AvVVaMs2VSNwQexQT5gTYU3TdWdYMn9UeztR0eF"
//				 								 + "rh3+dQetmsmwqRq6qfAmxhuKNBT5rQe5vBcHsFgyUqi+KTA2l0xLf6UHONLkoi7q"
//				 								 + "ZG/UagS9AgMBAAECggEBANP72QvIBF8Vqld8+q7FLlu/cDN1BJlniReHsqQEFDOh"
//				 								 + "pfiN+ZZDix9FGz5WMiyqwlGbg1KuWqgBrzRMOTCGNt0oteIM3P4iZlblZZoww9nR"
//				 								 + "sc4xxeXJNQjYIC2mZ75x6bP7Xdl4ko3B9miLrqpksWNUypTopOysOc9f4FNHG326"
//				 								 + "0EMazVaXRCAIapTlcUpcwuRB1HT4N6iKL5Mzk3bzafLxfxbGCgTYiRQNeRyhXOnD"
//				 								 + "eJox64b5QkFjKn2G66B5RFZIQ+V+rOGsQElAMbW95jl0VoxUs6p5aNEe6jTgRzAT"
//				 								 + "kqM2v8As0GWi6yogQlsnR0WBn1ztggXTghQs2iDZ0YkCgYEA/LzC5Q8T15K2bM/N"
//				 								 + "K3ghIDBclB++Lw/xK1eONTXN+pBBqVQETtF3wxy6PiLV6PpJT/JIP27Q9VbtM9UF"
//				 								 + "3lepW6Z03VLqEVZo0fdVVyp8oHqv3I8Vo4JFPBDVxFiezygca/drtGMoce0wLWqu"
//				 								 + "bXlUmQlj+PTbXJMz4VTXuPl1cesCgYEA6zu5k1DsfPolcr3y7K9XpzkwBrT/L7LE"
//				 								 + "EiUGYIvgAkiIta2NDO/BIPdsq6OfkMdycAwkWFiGrJ7/VgU+hffIZwjZesr4HQuC"
//				 								 + "0APsqtUrk2yx+f33ZbrS39gcm/STDkVepeo1dsk2DMp7iCaxttYtMuqz3BNEwfRS"
//				 								 + "kIyKujP5kfcCgYEA1N2vUPm3/pNFLrR+26PcUp4o+2EY785/k7+0uMBOckFZ7GIl"
//				 								 + "FrV6J01k17zDaeyUHs+zZinRuTGzqzo6LSCsNdMnDtos5tleg6nLqRTRzuBGin/A"
//				 								 + "++xWn9aWFT+G0ne4KH9FqbLyd7IMJ9R4gR/1zseH+kFRGNGqmpi48MS61G0CgYBc"
//				 								 + "PBniwotH4cmHOSWkWohTAGBtcNDSghTRTIU4m//kxU4ddoRk+ylN5NZOYqTxXtLn"
//				 								 + "Tkt9/JAp5VoW/41peCOzCsxDkoxAzz+mkrNctKMWdjs+268Cy4Nd09475GU45khb"
//				 								 + "Y/88qV6xGz/evdVW7JniahbGByQhrMwm84R9yF1mNwKBgCIJZOFp9xV2997IY83S"
//				 								 + "habB/YSFbfZyojV+VFBRl4uc6OCpXdtSYzmsaRcMjN6Ikn7Mb9zgRHR8mPmtbVfj"
//				 								 + "B8W6V1H2KOPfn/LAM7Z0qw0MW4jimBhfhn4HY30AQ6GeImb2OqOuh3RBbeuuD+7m"
//				 								 + "LpFZC9zGggf9RK3PfqKeq30q";

	//服务器公钥
	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyzJuMC2x9oCIsFH8Zmbc" +
			"a5KE0RkYFUoOtWWXo+YVn3UcEE+IOtyWe7cgT21Y4DHfYuwhUT3wGKllw76wQoKF" +
			"LJ0gPwSpBFKJYUBvJ0d3l8HwZfig2SrTikh4Tb7ojq9V62KW3qA7TreBUSuEIZxE" +
			"jHQbE9cObkSEgsk1ceOdiTLY7+sxISwBFfdlD+oZ4WYPDPku3OGAvvEn6T3iTkLt" +
			"EXFGv4j6od++hvsCgiMZ7F+NqGfbATPnsR0wC4nqJL0GuTYl41qTOzeE2Ljnlu7D" +
			"fbx9DjJheRRIEnniyIO+B9hpFvekrtPQKaNFdBMkc6Mk5yJcjjxCgAOlJ3RNJmlN" +
			"5wIDAQAB";

	//服务器私钥(经过pkcs8格式处理)
	private static final String serverPrvKeyPkcs8 = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDLMm4wLbH2gIiw" +
			"UfxmZtxrkoTRGRgVSg61ZZej5hWfdRwQT4g63JZ7tyBPbVjgMd9i7CFRPfAYqWXD" +
			"vrBCgoUsnSA/BKkEUolhQG8nR3eXwfBl+KDZKtOKSHhNvuiOr1XrYpbeoDtOt4FR" +
			"K4QhnESMdBsT1w5uRISCyTVx452JMtjv6zEhLAEV92UP6hnhZg8M+S7c4YC+8Sfp" +
			"PeJOQu0RcUa/iPqh376G+wKCIxnsX42oZ9sBM+exHTALieokvQa5NiXjWpM7N4TY" +
			"uOeW7sN9vH0OMmF5FEgSeeLIg74H2GkW96Su09Apo0V0EyRzoyTnIlyOPEKAA6Un" +
			"dE0maU3nAgMBAAECggEBAKPApXogKS4dUYq+16hytqnebzjPf1AQ2Z+oGreUAdL6" +
			"nr4qSgAdqwxSfTBlT92Fc6AV6Ze+UZKeWYuRThybcNWOXuFKUSdRmLMOKUW/W4qq" +
			"WaDj6ER7NfVYB9OnyWTLunMyhaEuAf2i9w1CA37On5ONMhEgG9oTT7LSkkaRB3D7" +
			"X4am2oNbqpQFk2vUh8FwqCGQrfWfM13dqzXsJ2R3r1FXC6wR8Z5E4abUs5ozzcys" +
			"q/W0nulZkINU2CWu+N+g5eMogYaW8RJp71f/pmuHxw9iSRUFJc/D2BzZfcNAP+Po" +
			"4udhSAz+caV3qLqq1QdEJqeExcTf3Ihzptjb/phxEiECgYEA9sSGTF25PTg/Iu9E" +
			"/QpvJQLHn6oSE3e24pu515M6VKKZPYK5+iW8Jwra07RnlT2OqQ9Cw3RnCFdViMlF" +
			"g7nethkAlsTB7XSnrumDNrmcdOQWcJmIJzk9KD9J1oBmitrWwHI5dW4eKp1fMhzM" +
			"hbdLFf94GsdpnrTwgGlU+1isrTcCgYEA0syY7m11sWyi0APTBYjyxGVnDKyRnxd1" +
			"jiliONzDpDsQuRNUM7GOfEKTBLY6FgGszZyFQDKvdfwaW3PPE/XcP2EpNc0oYqV0" +
			"wY16PxAyH8zy4L42vvpoPNTfHiFHauM/xn2gN7lj9Ivn33cw++qByFKtbPEdmS5x" +
			"xuorNRFhPNECgYAmv7di+Hik/1cSskXAAkpvol8cWEVcXzkNnmxxSIIpVhsACK4R" +
			"dKl17ANuqO53BeKH84iFTpr7OVOKFijfRWmOaKCqDB1znxTRp4NeLYk+5a4MYl95" +
			"4UgUMNP0Zdc0SKbeM1GIehEsmeef49vNx3l369S9R8DzFfCKCYA5s7PxwwKBgQCQ" +
			"nrFlEk+mc+OXVqhVqcj0GKWEOniFbzDFYXrzi/HlIGiusKYZ+PzKH1qB5wsewfNt" +
			"9K4uhxd9mIH0sBUnmouKJ/x/3sqQMvdROuDdlxzsWE1hBt7EU0NkSJ7yKt62ZEYC" +
			"xXlAAb6jrcBcvYcrrY1wg9hbX2hxCT4hu9H8zHmroQKBgQCEiACnDURhscEp77hA" +
			"1nSmw37RrL+Ha0JQ/CgLwOpeSfosT5UoxrPieuygl7qSK9Y/ZsSL3iKnRcT7qd1r" +
			"GkVW5DBRqL6e4u57NQJ7j76LB//01FsJ4hiEkTv5jBU3OWGDDVflltzEMNEA84cq" +
			"NGyt5JIzR6zgip8A4z/Qljk9LA==";

	public static String getServerPubKey() {
		return serverPubKey;
	}

	public static String getServerPrvKeyPkcs8() {
		return serverPrvKeyPkcs8;
	}
	
}
