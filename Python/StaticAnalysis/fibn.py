import argparse

def fib(n):
	a, b = 0, 1
	for i in range(n):
		a, b = b, a+b
	return a

def main():
	parser = argparse.ArgumentParser()
	parser.add_argument("num", help="desc sentence", type=int)

	group_mu = parser.add_mutually_exclusive_group()
	group_mu.add_argument("-v", "--verbose", action="store_true")
	group_mu.add_argument("-q", "--quiet", action="store_true")

	# group_re = parser.add_argument_group()
	# group_re.add_argument("-o", "--output", help="output the results to file", 
	# 					action="store_true")
	# group_re.add_argument("file", help="output filename", type=str)

	args = parser.parse_args()
	res = fib(args.num)

	if args.verbose:
		print("the "+str(args.num) + "th fib number is " + str(res))
	elif args.quiet:
		print(res)
	else:
		print("Fib("+str(args.num)+") = " + str(res))

	# if args.output:
	# 	f = open("output.txt", "a")
	# 	f.write(str(result) + "\n")

if __name__ == "__main__":
	main()
	# output: 1