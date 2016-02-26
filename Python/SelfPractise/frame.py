import sys


def print_trace():
    frame = sys._getframe()
    while frame:
        if not frame.f_back:
            break
        print(frame.f_code.co_filename)
        print(frame.f_code.co_name)
        print(frame.f_code.co_firstlineno)
        frame = frame.f_back

def main():
    print_trace()

if __name__ == '__main__':
    main()

