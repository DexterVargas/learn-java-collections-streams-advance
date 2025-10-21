# Java Stream API

### Stream Pipeline Structure
> Source → Intermediate Operations → Terminal Operation

#### example
```
List<String> names = List.of("Dexter", "John", "Jane", "Dex");
names.stream()
    .filter(n -> n.startsWith("J"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);
```


### Common Operations

| Type         | Operation                  | Description                       |
| ------------ | -------------------------- | --------------------------------- |
| Intermediate | `.filter()`                | Keep elements meeting a condition |
| Intermediate | `.map()`                   | Transform elements                |
| Intermediate | `.sorted()`, `.distinct()` | Sort or remove duplicates         |
| Terminal     | `.collect()`               | Gather into List/Map/Set          |
| Terminal     | `.forEach()`               | Loop over                         |
| Terminal     | `.reduce()`                | Combine to single result          |
| Terminal     | `.count()`                 | Count elements                    |

#### Example: Word Frequency using Streams

```
Map<String, Long> result =
    List.of("apple", "banana", "apple", "orange", "banana", "apple")
        .stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
System.out.println(result); // {orange=1, banana=2, apple=3}
```