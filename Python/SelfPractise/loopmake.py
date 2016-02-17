#!/bin/env python3


dashes = '\n' + '-' * 50
exec_dict = {
'f': '''
for %s in %s:
    print(%s)
''',
's': '''
%s = 0
%s = %s
while %s < len(%s):
    print(%s[%s])
    %s += 1
''',
'n': '''
%s = %d
while %s < %d:
    print(%s)
    %s += %d
'''
}

def main():
    ltype = input('Loop type? (for / while) ')
    dtype = input('Data type? (number / seq) ')
    exec_str = ''

    if dtype == 'n':
        start = int(input('start value? '))
        stop = int(input('ending value (non-inclusive) '))
        step = int(input('stepping value '))
        seq = str(range(start, stop, step))
    else:
        seq = input('enter sequence: ')

    var = input('iterative variable name? ')

    if ltype == 'f':
        exec_str = exec_dict['f'] % (var, seq, var)
    elif ltype == 'w':
        if dtype == 's':
            svar = input('enter sequence name? ')
            exec_str = exec_dict['s'] % \
                (var, svar, seq, var, svar, svar, var, var)
        elif dtype == 'n':
            exec_str = exec_dict['n'] % \
                (var, start, var, stop, var, var, step)

    print(dashes)
    print('your custom-generated code: ' + dashes)
    print(exec_str + dashes)
    print('test execution of the code: ' + dashes)
    exec(exec_str)
    print(dashes)

if __name__ == '__main__':
    main()

