import numpy as np
import matplotlib.pyplot as plt

def question_func(x):
    a = 20
    b = 0.2
    c = 2 * np.pi
    d = len(x)
    p1 = -b * np.sqrt(1 / d * (np.sum(x ** 2)))
    listcos = []
    for i in x:
        cosx = np.cos(c * i)
        listcos.append(cosx)
    sumcos = sum(listcos)
    p2 = 1 / d * sumcos
    return -a*np.exp(p1) - np.exp(p2) + a + np.exp(1)

def run():

    nvar = 30
    varmin = -32
    varmax = 32

    #参数
    npop = 20 #种群数量
    pc =1
    nc = int(np.round(pc*npop/2)*2)
    #最大迭代次数
    maxit= 100000
    accep = 0.1 #精确值
    gamma = 0.1 #交叉参数
    sigma = 0.3
    mu = 0.03
    beta = 1

    # 最优解决方案的值
    bestsolVal = np.inf

    # 种群初始化
    pop = [[0]*nvar]*npop #创建多维数组
    for i in range(0, npop):
        pop[i] = np.random.uniform(varmin, varmax, nvar)
        cost = question_func(pop[i])
        if cost < bestsolVal:
            bestsolVal = cost
    print(pop)

    # 交互最优解数组
    bestcost = []
    #迭代次数
    it = 0

    while bestsolVal > accep and maxit > it:
        costs = np.array([question_func(x) for x in pop])
        avg_cost = np.mean(costs)#一维数组，则计算均值，二维时则默认计算每一列的均值
        if avg_cost != 0:
            costs = costs / avg_cost

        probs = np.exp(-beta * costs)

        popc = []
        for _ in range(nc // 2):  # nc = number of children
            # 选择
            p1 = pop[roulette_wheel_selection(probs)]
            p2 = pop[roulette_wheel_selection(probs)]

            # 交叉
            c1, c2 = crossover(p1, p2, gamma)

            # 变异
            c1 = mutate(c1, mu, sigma)
            c2 = mutate(c2, mu, sigma)

            # 检查变异值是否超过限度，如果有则取限度值即可
            apply_bound(c1, varmin, varmax)
            apply_bound(c2, varmin, varmax)

            # 评估第一个后代
            cost1 = question_func(c1)
            if cost1 < bestsolVal:
                bestsolVal = cost1

            # 评估第二个后代
            cost2 = question_func(c2)
            if cost2 < bestsolVal:
                bestsolVal =cost2

            # 选择交叉变异后生成的后代，添加至种群中
            popc.append(c1)
            popc.append(c2)

        # 合并，排序，选择
        pop = pop + popc
        pop = sorted(pop, key=lambda x: question_func(x))
        #仅保留 npop个个体
        pop = pop[0:npop]

        # 存储本次交互最优解
        bestcost.append(bestsolVal)

        # 打印交互信息
        print("Interation {}: best output/cost = {}".format(it, bestcost[it]))

        it = it + 1
    return bestcost,it

#初始化种群
def initialPopulation(length, populationSize):
    # 根据DNA长度和种群大小初始化种群
    chromsomes = np.zeros((populationSize, length), dtype=np.int)
    for popusize in range(populationSize):
        # np.random.randint产生[0,2)之间的随机整数，第三个数表示随机数的数量
        chromsomes[popusize, :] = np.random.randint(0, 2, length)
    return chromsomes

# 交叉
def crossover(p1, p2, gamma):
    c1 = p1
    c2 = p2
    alpha = np.random.uniform(-gamma, 1 + gamma, c1.shape)
    c1 = alpha * p1 + (1 - alpha) * p2
    c2 = alpha * p2 + (1 - alpha) * p1

    return c1, c2


# 变异
def mutate(x, mu, sigma):
    y = x
    flag = np.random.rand(*x.shape) <= mu
    ind = np.argwhere(flag)#返回非0的数组元组的索引,返回形式：array([[1],[2],[5],[6]])
    y[ind] += sigma * np.random.randn(*ind.shape)
    return y


# Check limits
def apply_bound(x, varmin, varmax):  # shuffle the result
    x = np.maximum(x, varmin)
    x = np.minimum(x, varmax)
    return x


# 轮盘赌（选择）
def roulette_wheel_selection(p):
    c = np.cumsum(p)
    r = sum(p) * np.random.rand()
    ind = np.argwhere(r <= c)
    return ind[0][0]


#主方法
def main():

    print('遗传算法求最优解：')
    print('题目：http://www.sfu.ca/~ssurjano/ackley.html')
    # output = run();
    bestcost,it = run();

    # 结果打印
    plt.rcParams['font.sans-serif'] = ['SimHei']  # 用来正常显示中文标签
    plt.rcParams['axes.unicode_minus'] = False  # 用来正常显示负号
    plt.plot(bestcost, 'r', linewidth=1)
    plt.semilogy(bestcost)
    plt.xlim(0, it)
    plt.xlabel('迭代次数')
    plt.ylabel('输出值')
    plt.title('遗传算法 (Genetic Algorithm)')
    plt.grid(False)
    plt.show()


if __name__ == '__main__':
    main()

