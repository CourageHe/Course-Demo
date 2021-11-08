import tensorflow as tf



def print_hi():
    hello = tf.constant('hello World!')
    sess = tf.Session()
    print(sess.run(hello))


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi()