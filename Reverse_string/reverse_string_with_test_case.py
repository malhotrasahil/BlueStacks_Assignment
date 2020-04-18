def reverse_each_word(sentence):
    words = sentence.split(' ')
    output = []
    for word in words:
        if word.isalnum():
            output.append(word[::-1])
        else:
            out_word = []
            d = {}
            for index, char in enumerate(word):
                if char.isalnum():
                    out_word.append(char)
                else:
                    d[index] = char
            out_word = out_word[::-1]

            for k, v in d.items():
                out_word.insert(k, v)
            output.append(''.join(out_word))
    return ' '.join(output)


def main():
    test_str = "String; 2be reversed..."
    assert reverse_each_word(test_str) ==  "gnirtS; eb2 desrever..."
    test_str = ""
    assert reverse_each_word(test_str) == ""
    test_str = " "
    assert reverse_each_word(test_str) == " "
    test_str = "?"
    assert reverse_each_word(test_str) == "?"
    test_str = "a,dcb"
    assert reverse_each_word(test_str) ==  "b,cda"
    test_str = "1"
    assert reverse_each_word(test_str) == "1"
    test_str = "12345"
    assert reverse_each_word(test_str) == "54321"
    test_str = "abcd "
    assert reverse_each_word(test_str) == "dcba "
    test_str = "I love BlueStacks"
    assert reverse_each_word(test_str) == "I evol skcatSeulB"
    return 0

main()