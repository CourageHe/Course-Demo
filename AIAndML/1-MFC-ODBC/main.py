# 学生信息 字典对象（key——》value），用作存储
dict = {}

# 输入学生信息
def scanner_stuXX():
    stuName = input("姓名：")
    stuXh = input("学号：")
    stuYwcj = input("语文成绩：")
    stuSxcj = input("数学成绩：")
    stuYycj = input("英语成绩：")
    stuStr= stuName+","+stuXh+","+stuYwcj+","+stuSxcj+","+stuYycj
    return parse_stuXX(stuStr)
# 由字符串解析为学生信息数组
def parse_stuXX(stuStr):
    arr = stuStr.split(',')
    return arr;
# 格式化打印学生信息
def print_stuXX(stu):
    print("姓名：" + stu[0]+"，"+"学号：" + stu[1]+"，"+"语文成绩：" + stu[2]+"，"+"数学成绩："+ stu[3]+"，"+"英语成绩："+ stu[4])

# 打印分界线
def print_dividingLine(name):
    print("==============="+name+"==================")

# 打印选项
def print_item(item):
    print("     "+item)

# 打印菜单
def print_menu():
    print_dividingLine(" 学生成绩管理系统 ")
    print_item("1、添加学生成绩 ")
    print_item("2、删除学生成绩 ")
    print_item("3、查询学生成绩 ")
    print_item("4、修改学生成绩 ")
    print_item("5、学生成绩列表 ")
    print_item("0、退出系统 ")
    print_dividingLine("")

# 文本持久化写入
def text_write():
    f = open("data.txt",'w')
    for key in dict:
        # print(key+":"+dict[key])
        f.writelines(dict[key]+"\n")
    f.close()

# 初始化读取
def text_read():
    f = open("data.txt",'r')
    for line in f.readlines():
        line  = line.strip('\n') # 去除换行符
        if line != None and  line.__contains__(','):
            stu = parse_stuXX(line)
            dict[stu[1]] = stu[0]+","+stu[1]+","+stu[2]+","+stu[3]+","+stu[4]
    f.close()

# 添加学生成绩
def addStuCj():
    stu = scanner_stuXX();
    dict[stu[1]] = stu[0]+","+stu[1]+","+stu[2]+","+stu[3]+","+stu[4]
# 删除学生成绩
def delStuCj():
    stuXh = input("请输入要删除的学生的学号：")
    del dict[stuXh]

# 查询学生成绩
def queryStuCj():
    stuXh = input("请输入要查询的学生的学号：")
    stuStr = dict[stuXh]
    stu  = parse_stuXX(stuStr)
    # 直接删除该学生，这样学号亦可以修改
    del dict[stuXh]
    print_stuXX(stu)
# 更新学生成绩
def updateStuCj():
    stuXh = input("请输入要更新的学生的学号：")
    stuStr = dict[stuXh]
    stu  = parse_stuXX(stuStr)
    print_stuXX(stu)
    print_dividingLine(" 请输入修改后的学生信息： ")
    stu = scanner_stuXX();
    dict[stu[1]] = stu[0]+","+stu[1]+","+stu[2]+","+stu[3]+","+stu[4]

# 学生成绩列表打印
def listStuCj():
    for key in dict:
        stu  = parse_stuXX(dict[key])
        print_stuXX(stu)

# 退出系统
def exit_sys():
    #退出系统前，持久化结果
    text_write()
    exit()

def main():
    while 1==1:
        print_menu()
        f= input()
        if f == '1':
            addStuCj()
        elif f == '2':
            delStuCj()
        elif f == '3':
            queryStuCj()
        elif f == '4':
            updateStuCj()
        elif f == '5':
            listStuCj()
        elif f == '0':
            exit_sys()
        else:
            exit_sys()

if __name__ == '__main__':
    #进入菜单之前，读取本地文本文件存储的结果
    text_read()
    main()
