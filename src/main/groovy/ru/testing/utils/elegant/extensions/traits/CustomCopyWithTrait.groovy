package ru.testing.utils.elegant.extensions.traits

trait CustomCopyWithTrait {
    <T> T customCopyWith(Map args = [:]) {
        def props = this.properties.findAll { k, v -> k != 'class' }
        def values = [:] + props + args
        return (T) this.class.newInstance(values)
    }

    <T> T customCopyWith(@DelegatesTo.Target Object self = this, @DelegatesTo(strategy = Closure.DELEGATE_FIRST) Closure c) {
        Closure clonedClosure = (Closure) c.clone()
        def map = [:]
        clonedClosure.delegate = map
        clonedClosure.resolveStrategy = Closure.DELEGATE_FIRST
        clonedClosure()
        return customCopyWith(map)
    }
}