import re
from typing import List

import matplotlib.pyplot as plt
from matplotlib.ticker import ScalarFormatter

regex = re.compile(r"size:\s+(?P<size>-?\d+);\s+elapsed:\s+(?P<elapsed>-?\d+)")


def plot_performance_graph(
    title: str,
    source_file_name: str,
    target_file_name: str,
) -> None:
    with open(
        file=source_file_name,
        mode="r",
        encoding="utf-8",
    ) as fh:
        raw = fh.readlines()

    sizes: List[int] = []
    elapsed_times: List[float] = []

    for line in raw:
        match = regex.match(line)
        if match is None:
            continue

        size, elapsed = map(int, match.group("size", "elapsed"))
        sizes.append(size)
        elapsed_times.append(elapsed / 10e6)

    plt.plot(sizes, elapsed_times, marker="o", linestyle="-", color="b")

    plt.xlabel("Кол-во чисел")
    plt.ylabel("Время выполнения, ms")
    plt.title(title)

    plt.gca().xaxis.set_major_formatter(ScalarFormatter())
    plt.gca().yaxis.set_major_formatter(ScalarFormatter())

    plt.gca().ticklabel_format(style="plain", axis="x")
    plt.gca().ticklabel_format(style="plain", axis="y")

    plt.grid(True)

    plt.savefig(target_file_name)
    plt.clf()


def main() -> None:
    plot_performance_graph(
        title="Максимальный элемент в списке",
        source_file_name="performance_max.txt",
        target_file_name="graphs/performance_max_graph.png",
    )
    plot_performance_graph(
        title="Минимальный элемент в списке",
        source_file_name="performance_min.txt",
        target_file_name="graphs/performance_min_graph.png",
    )
    plot_performance_graph(
        title="Произведение элементов списка",
        source_file_name="performance_mult.txt",
        target_file_name="graphs/performance_mult_graph.png",
    )
    plot_performance_graph(
        title="Сложение элементов списка",
        source_file_name="performance_sum.txt",
        target_file_name="graphs/performance_sum_graph.png",
    )


if __name__ == "__main__":
    main()
