import sys

def pascal_triangle(level, line=0, print_flag=True):
    def elem(i, j):
        return 1 if (j >= i or j == 0) else elem(i-1, j-1) + elem(i-1, j)
    format_line = " ".join([str(elem(line, j)) for j in range(line+1)])
    if print_flag:
        print(format_line)
    if line < level:
        pascal_triangle(level, line+1, print_flag)

def main():
    levels = int(sys.argv[1])
    flag = "-print" in " ".join(sys.argv)
    if levels < 0:
        raise ValueError("Argument must be greater than zero.")
    pascal_triangle(levels, print_flag=flag)


if __name__ == "__main__":
    main()
