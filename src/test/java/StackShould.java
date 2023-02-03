import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StackShould {

    private Stack stack;

    @Test
    void be_empty_when_push_method_has_been_called() {
        stack = new Stack(0);

        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.size()).isZero();
    }

    @Test
    void not_be_empty_when_push_method_is_called() {
        stack = new Stack(1);

        stack.push(3);

        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isNotZero();
    }

    @Test
    void push_more_than_once() {
        stack = new Stack(2);

        stack.push(3);
        stack.push(11);

        assertThat(stack.size()).isEqualTo(2);
    }

    @Test
    void pop_the_last_element_from_the_stack() {
        stack = new Stack(2);

        stack.push(3);
        stack.push(11);

        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(11);
    }

    @Test
    void peek_the_last_element() {
        stack = new Stack(3);

        stack.push(3);
        stack.push(1);
        stack.push(9);

        assertThat(stack.peek()).isEqualTo(9);
        assertThat(stack.size()).isEqualTo(3);
    }

    @Test
    void handle_overflows_when_too_many_elements_are_pushed_to_the_stack() {
        stack = new Stack(0);

        assertThatThrownBy(() -> stack.push(3)).isInstanceOf(OverflowException.class);
    }

    @Test
    void handle_underflows_when_too_many_elements_are_popped_off_the_stack() {
        stack = new Stack(0);

        assertThatThrownBy(stack::pop).isInstanceOf(UnderflowException.class);
    }

    @Test
    void handle_underflows_when_there_are_no_elements_to_peek_on_the_stack() {
        stack = new Stack(0);

        assertThatThrownBy(stack::peek).isInstanceOf(UnderflowException.class);
    }

    @Test
    void handle_attempts_to_create_a_stack_with_an_invalid_capacity() {
        assertThatThrownBy(() -> new Stack(-1)).isInstanceOf(InvalidCapacityException.class);
    }
}
